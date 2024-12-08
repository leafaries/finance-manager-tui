package com.leafaries.tui.features.wallet.controller;

import com.leafaries.tui.model.WalletHttpRequestDto;
import com.leafaries.tui.model.WalletResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class WalletService {

    private final WebClient webClient;

    public Mono<WalletResponseDto> createWallet(WalletHttpRequestDto walletHttpRequestDto) {
        // TODO: Implement
        return webClient.post()
                .uri("/wallet")
                .bodyValue(walletHttpRequestDto)
                .retrieve()
                .bodyToMono(WalletResponseDto.class);
    }

    public Flux<WalletResponseDto> getAllWallets() {
        // TODO: Implement
        return webClient.get()
                .uri("/wallets")
                .retrieve()
                .bodyToFlux(WalletResponseDto.class);
    }

    public Mono<WalletResponseDto> getWalletById(Long id) {
        // TODO: Implement
        return webClient.get()
                .uri("/wallet/" + id)
                .retrieve()
                .bodyToMono(WalletResponseDto.class);
    }

    public Mono<WalletResponseDto> updateWallet(Long id, WalletHttpRequestDto walletHttpRequestDto) {
        // TODO: Implement
        return webClient.put()
                .uri("/wallet/" + id)
                .bodyValue(walletHttpRequestDto)
                .retrieve()
                .bodyToMono(WalletResponseDto.class);
    }

    public Mono<Void> deleteWallet(Long id) {
        // TODO: Implement
        return webClient.delete()
                .uri("/wallet/" + id)
                .retrieve()
                .bodyToMono(Void.class);
    }

}
