package com.leafaries.tui.model;

public class WalletHttpRequestDto {
    public String name;
    public Double balance;
    public String currency;

    public WalletHttpRequestDto(Double balance, String currency, String name) {
        this.balance = balance;
        this.currency = currency;
        this.name = name;
    }
}
