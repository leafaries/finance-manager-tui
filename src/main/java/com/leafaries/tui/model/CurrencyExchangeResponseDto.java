package com.leafaries.tui.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CurrencyExchangeResponseDto {

    private String disclaimer;
    private String license;
    private Long timestamp;
    private String base;
    private String rates;

}
