package com.leafaries.tui.service;

import com.leafaries.tui.model.WalletHttpRequestDto;
import com.leafaries.tui.model.WalletResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class WalletService {
    private final WebClient webClient;

    public WalletService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void createWallet(WalletHttpRequestDto walletHttpRequestDto) {
        // TODO: Implement
    }

    public void updateWallet(Long id, WalletHttpRequestDto walletHttpRequestDto) {
        // TODO: Implement
    }

    public void deleteWallet(Long id) {
        // TODO: Implement
    }

    public List<WalletResponseDto> getAllWallets() {
        // TODO: Implement
        return null;
    }

    public WalletResponseDto getWalletById(Long id) {
        // TODO: Implement
        return null;
    }
}