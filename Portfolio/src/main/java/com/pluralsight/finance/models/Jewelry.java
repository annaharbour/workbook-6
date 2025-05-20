package com.pluralsight.finance.models;

import java.math.BigDecimal;

public class Jewelry extends FixedAsset{
    private double karat;

    public Jewelry(String name, BigDecimal marketValue, double karat) {
        super(name, marketValue);
        this.karat = karat;
    }

    public double getKarat() {
        return karat;
    }

    public void setKarat(double karat) {
        this.karat = karat;
    }

    @Override
    public BigDecimal getValue() {
        return this.getMarketValue().multiply(BigDecimal.valueOf(this.karat));
    }

    @Override
    public String toString() {
        return "Jewelry: " + this.getName() +
                "\n\t" + karat + " karats" +
                "\n\tValue: $" + String.format("%.2f", this.getValue());
    }
}
