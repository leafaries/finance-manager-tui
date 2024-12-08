package com.leafaries.tui.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class WalletResponseDto {

    private Long id;
    private String name;
    private BigDecimal balance;
    private String currency;

}
