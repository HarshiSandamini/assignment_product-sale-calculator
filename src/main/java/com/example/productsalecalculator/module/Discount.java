package com.example.productsalecalculator.module;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Discount {
    @Id
    private Long id;
    private int minDiscountAmount;
    private PurchaseType purchaseType;
    private double discountPrice;

    public Discount(Long id, int minDiscountAmount, PurchaseType purchaseType, float discountPrice) {
        this.id = id;
        this.minDiscountAmount = minDiscountAmount;
        this.purchaseType = purchaseType;
        this.discountPrice = discountPrice;
    }

    public Discount() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinDiscountAmount() {
        return minDiscountAmount;
    }

    public void setMinDiscountAmount(int minDiscountAmount) {
        this.minDiscountAmount = minDiscountAmount;
    }

    public PurchaseType getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(PurchaseType purchaseType) {
        this.purchaseType = purchaseType;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
}
