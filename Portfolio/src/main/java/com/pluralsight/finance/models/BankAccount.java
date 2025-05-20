package com.pluralsight.finance.models;

import java.math.BigDecimal;

public class BankAccount implements Valuable{
    private String accountNumber;
    private BigDecimal balance;

    public BankAccount(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void withdraw(BigDecimal amount){
        this.balance = this.balance.subtract(amount);
    }

    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    @Override
    public BigDecimal getValue() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Bank Account " + accountNumber +
                "\n\t Balance is $" + String.format("%.2f", balance);    }
}
