package com.example.productsalecalculator.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long prodId;
    private String prodName;
    private float cartonPrice;
    private int unitsPerCarton;

    public Product(Long prodId, String prodName, float cartonPrice, int unitsPerCarton) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.cartonPrice = cartonPrice;
        this.unitsPerCarton = unitsPerCarton;
    }

    public Product() {

    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public float getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(float cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public int getUnitsPerCarton() {
        return unitsPerCarton;
    }

    public void setUnitsPerCarton(int unitsPerCarton) {
        this.unitsPerCarton = unitsPerCarton;
    }

    @Override
    public String toString() {
        return "product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", cartonPrice=" + cartonPrice +
                ", unitsPerCarton=" + unitsPerCarton +
                '}';
    }
}
