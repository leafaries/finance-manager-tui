package com.leafaries.tui.model;

import java.math.BigDecimal;

public class WalletResponseDto {
    public Long id;
    public String name;
    public BigDecimal balance;
    public String currency;

    public WalletResponseDto(BigDecimal balance, String currency, Long id, String name) {
        this.balance = balance;
        this.currency = currency;
        this.id = id;
        this.name = name;
    }
}
