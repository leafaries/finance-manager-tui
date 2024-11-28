package com.leafaries.tui.model;

public class TransactionDto {
    public Double amount;
    public Long walletId;
    public String date;
    public String category;
    public String notes;

    public TransactionDto(Double amount, String category, String date, String notes, Long walletId) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.notes = notes;
        this.walletId = walletId;
    }
}
