package com.pluralsight.finance.models;

import java.math.BigDecimal;

public class Gold extends FixedAsset {
    private double weight;

    public Gold(String name, BigDecimal marketValue, double weight) {
        super(name, marketValue);
        this.weight = weight;
    }

    @Override
    public BigDecimal getValue() {
        return this.getMarketValue().multiply(BigDecimal.valueOf(this.weight));
    }

    @Override
    public String toString() {
        return weight + " of Gold" + "\n\tValue: $" + String.format("%.2f", this.getValue());
    }
}
