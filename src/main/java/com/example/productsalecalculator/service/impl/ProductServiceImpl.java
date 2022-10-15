package com.example.productsalecalculator.service.impl;

import com.example.productsalecalculator.module.Product;
import com.example.productsalecalculator.payload.request.ProductPriceRequest;
import com.example.productsalecalculator.payload.response.ProductPriceResponse;
import com.example.productsalecalculator.payload.response.ProductResponse;
import com.example.productsalecalculator.repository.DiscountRepository;
import com.example.productsalecalculator.repository.ProductRepository;
import com.example.productsalecalculator.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProductServiceImpl implements ProductService {
    final
    ProductRepository productRepository;

    final
    DiscountRepository discountRepository;

    public ProductServiceImpl(DiscountRepository discountRepository, ProductRepository productRepository) {
        this.discountRepository = discountRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Page<ProductResponse> list(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Product> pageResult = productRepository.findAll(pageRequest);
        List<ProductResponse> products = pageResult
                .stream()
                .map(ProductResponse::new)
                .collect(toList());
        return new PageImpl<>(products, pageRequest, pageResult.getTotalElements());
    }

    @Override
    public ProductPriceResponse calculatePrice(ProductPriceRequest productPriceRequest) {
        Product product = productRepository.findById(productPriceRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Error: Product not found."));
        int qty = productPriceRequest.getQty();
        int noupc = product.getUnitsPerCarton();
        switch (productPriceRequest.getPurchaseType()){
            case UNIT:
                return priceForUnits((int) product.getCartonPrice(), qty, noupc);
            case CARTON:
                return  new ProductPriceResponse(qty  * noupc, qty, 0,
                        (float) calculatePrice(qty, 0, product.getCartonPrice(), noupc));
        }
        return null;
    }

    @Override
    public List<ProductPriceResponse> calculatePriceList(Long productId, int units) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Error: Product not found."));

        List<ProductPriceResponse> priceList = new ArrayList<>();
        for(int i = 1; i <= units; i++){
            priceList.add(priceForUnits((int) product.getCartonPrice(),i,product.getUnitsPerCarton()));
        }
        return priceList;
    }

    private double calculatePrice(int cartons, int units, double cartonCost, int noupc){
        double totalPrice = cartons * cartonCost + cartonCost/noupc * units;
        if (cartons == 0){
            totalPrice *= 1.3;
        }else if(cartons >= 3){
            totalPrice *= 0.9;
        }
        return totalPrice;
    }

    private ProductPriceResponse priceForUnits(int qty, double cartonPrica , int unitsPerCArton){
        int cartons = qty/unitsPerCArton;
        int units = 0;

        if(cartons > 0){
            units = qty % unitsPerCArton;
        } else {
            cartons = 0;
            units = qty;
        }
        return  new ProductPriceResponse(qty, cartons, units, (float) calculatePrice(cartons, units, cartonPrica, unitsPerCArton));
    }
}
