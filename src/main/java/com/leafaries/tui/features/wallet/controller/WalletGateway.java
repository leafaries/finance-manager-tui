package com.leafaries.tui.features.wallet.controller;

import com.leafaries.tui.model.WalletHttpRequestDto;
import com.leafaries.tui.model.WalletResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WalletGateway {

    Mono<WalletResponseDto> createWallet(WalletHttpRequestDto walletHttpRequestDto);

    Flux<WalletResponseDto> getAllWallets();

    Mono<WalletResponseDto> getWalletById(Long id);

    Mono<WalletResponseDto> updateWallet(Long id, WalletHttpRequestDto walletHttpRequestDto);

    Mono<Void> deleteWallet(Long id);

}
