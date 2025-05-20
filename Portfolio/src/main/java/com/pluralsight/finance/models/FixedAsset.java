package com.pluralsight.finance.models;

import java.math.BigDecimal;

public abstract class FixedAsset implements Valuable {
    private String name;
    private BigDecimal marketValue;

    public FixedAsset(String name, BigDecimal marketValue){
        this.name = name;
        this.marketValue = marketValue;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public abstract BigDecimal getValue();
}
