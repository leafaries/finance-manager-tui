package com.leafaries.tui.service;

import com.leafaries.tui.model.TransactionCreateDto;
import com.leafaries.tui.model.TransactionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@AllArgsConstructor
@Service
public class TransactionService {

    private final WebClient webClient;

    public void createTransaction(TransactionCreateDto transactionCreateDto) {
        // TODO: Implement
    }

    public void updateTransaction(Long id, TransactionCreateDto transactionCreateDto) {
        // TODO: Implement
    }

    public void deleteTransaction(Long id) {
        // TODO: Implement
    }

    public List<TransactionDto> getAllTransactions() {
        // TODO: Implement
        return null;
    }

    public TransactionDto getTransactionById(Long id) {
        // TODO: Implement
        return null;
    }

}
