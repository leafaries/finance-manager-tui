package com.leafaries.tui.service;

import com.leafaries.tui.model.CurrencyExchangeResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class CurrencyExchangeService {

    private final WebClient webClient;

    public CurrencyExchangeResponseDto getLatestExchangeRates() {
        // TODO: Implement
        return null;
    }

    public CurrencyExchangeResponseDto getHistoricalExchangeRates(LocalDate date) {
        // TODO: Implement
        return null;
    }

}
