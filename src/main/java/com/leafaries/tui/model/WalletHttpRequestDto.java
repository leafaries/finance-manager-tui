package com.leafaries.tui.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WalletHttpRequestDto {

    private String name;
    private Double balance;
    private String currency;

}
