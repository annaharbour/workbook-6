package com.pluralsight.finance.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name;
    private String owner;

    private ArrayList<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }


    public List<Valuable> getAssets() {
        return assets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void add(Valuable asset) {
        this.assets.add(asset);
    }

    public Valuable getMostValuable() {
        Valuable leastValuable = assets.get(0);
        for (Valuable asset : assets) {
            if (leastValuable.getValue().compareTo(asset.getValue()) < 0) {
                leastValuable = asset;
            }
        }
        return leastValuable;
    }

    public Valuable getLeaseValuable() {
        Valuable leastValuable = assets.get(0);
        for (Valuable asset : assets) {
            if (leastValuable.getValue().compareTo(asset.getValue()) > 0) {
                leastValuable = asset;
            }
        }
        return leastValuable;
    }


    public BigDecimal getValue() {
        BigDecimal totalValue = new BigDecimal(0);
        for (Valuable asset : this.assets) {
            totalValue = totalValue.add(asset.getValue());
        }
        return totalValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PORTFOLIO: " +
                name +
                "\n\tOwner:" + owner +
                "\n\tAssets" + (assets) +
                "\n\tPortfolio Value: $" + String.format("%.2f", this.getValue()) +
                "\n\tLeast Valuable" + this.getLeaseValuable()
                + "\n\tMost Valuable" + this.getMostValuable()
        );
        return sb.toString();
    }
}
