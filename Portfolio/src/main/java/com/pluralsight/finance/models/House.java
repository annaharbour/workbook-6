package com.pluralsight.finance.models;

import java.math.BigDecimal;

public class House extends FixedAsset {
    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    public House(String name, BigDecimal marketValue, int yearBuilt, int squareFeet, int bedrooms) {
        super(name, marketValue);
        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    @Override
    public BigDecimal getValue() {
        return this.getMarketValue().multiply(BigDecimal.valueOf(this.squareFeet));
    }


    @Override
    public String toString() {
        return "House " + this.getName() + "\n\t" + this.bedrooms + " bedrooms" + "\n\t" + this.squareFeet + "sq ft" +
                "\n\tYear Built: " + this.yearBuilt +
                "\n\tValue: $" + String.format("%.2f", this.getValue());    }
}
