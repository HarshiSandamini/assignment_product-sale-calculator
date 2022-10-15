package com.example.productsalecalculator.payload.response;

public class ProductPriceResponse {
    int units;
    int numOfCartons;
    int numOfUnits;
    float price;

    public ProductPriceResponse(int units, int numOfCartons, int numOfUnits, float price) {
        this.units = units;
        this.numOfCartons = numOfCartons;
        this.numOfUnits = numOfUnits;
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getNumOfCartons() {
        return numOfCartons;
    }

    public void setNumOfCartons(int numOfCartons) {
        this.numOfCartons = numOfCartons;
    }

    public int getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(int numOfUnits) {
        this.numOfUnits = numOfUnits;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
