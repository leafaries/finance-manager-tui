package com.leafaries.tui.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDto {

    private Double amount;
    private Long walletId;
    private String date;
    private String category;
    private String notes;

}
