package com.example.productsalecalculator.service;

import com.example.productsalecalculator.payload.request.ProductPriceRequest;
import com.example.productsalecalculator.payload.response.ProductPriceResponse;
import com.example.productsalecalculator.payload.response.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<ProductResponse> list(int page, int size);

    ProductPriceResponse calculatePrice(ProductPriceRequest productPriceRequest);

    List<ProductPriceResponse> calculatePriceList(Long productId, int units);
}
