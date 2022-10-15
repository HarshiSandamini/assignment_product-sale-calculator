package com.example.productsalecalculator.controller;

import com.example.productsalecalculator.payload.request.ProductPriceRequest;
import com.example.productsalecalculator.payload.response.ProductPriceResponse;
import com.example.productsalecalculator.payload.response.ProductResponse;
import com.example.productsalecalculator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public Page<ProductResponse> list(@RequestParam(name = "page", defaultValue = "0") int page,
                                      @RequestParam(name = "size", defaultValue = "10") int size) {
        return productService.list(page,size);
    }

    @PostMapping("/calculate-price")
    public ResponseEntity<ProductPriceResponse> calculateProductPrice(@RequestBody ProductPriceRequest productPriceRequest) {
        return ResponseEntity.ok(productService.calculatePrice(productPriceRequest));
    }

    @GetMapping("/calculate-price-list")
    public ResponseEntity<List<ProductPriceResponse>> calculatePriceList(@RequestParam("productId") Long productId,
                                                                         @RequestParam(name = "units", defaultValue = "50") int units) {
        return ResponseEntity.ok(productService.calculatePriceList(productId, units));
    }


}
