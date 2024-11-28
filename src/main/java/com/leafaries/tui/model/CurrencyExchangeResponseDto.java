package com.leafaries.tui.model;

public class CurrencyExchangeResponseDto {
    public String disclaimer;
    public String license;
    public Long timestamp;
    public String base;
    public String rates;

    public CurrencyExchangeResponseDto(String base, String disclaimer, String license, String rates, Long timestamp) {
        this.base = base;
        this.disclaimer = disclaimer;
        this.license = license;
        this.rates = rates;
        this.timestamp = timestamp;
    }
}
