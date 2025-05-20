package com.pluralsight.finance.models;

import java.math.BigDecimal;

public class CreditCard implements Valuable {
    String accountNumber;
    BigDecimal balance;

    public CreditCard(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void charge(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public void pay(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    @Override
    public BigDecimal getValue() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Credit Card " + accountNumber +
                "\n\t Balance is $" + String.format("%.2f", balance);
    }
}
