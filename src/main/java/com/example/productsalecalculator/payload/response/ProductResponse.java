package com.example.productsalecalculator.payload.response;

import com.example.productsalecalculator.module.Product;

public class ProductResponse {

    private Long id;
    private String name;
    private float cartonPrice;

    public ProductResponse(Product product) {
        this.id = product.getProdId();
        this.name = product.getProdName();
        this.cartonPrice = product.getCartonPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(float cartonPrice) {
        this.cartonPrice = cartonPrice;
    }
}
