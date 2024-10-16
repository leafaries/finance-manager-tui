package com.leafaries.tui.archivedcode.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockedCurrencyConverterModel extends AbstractCurrencyConverterModel {

    private final ObjectMapper objectMapper;

    public MockedCurrencyConverterModel() {
        super();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<String> availableCurrencies() {
        final List<String> currencyCodes = new ArrayList<>();
        try {
            final String content = new String(Files.readAllBytes(Paths.get(currenciesFilePath)));
            final Map<String, String> currencyMap = new ObjectMapper().readValue(content, new TypeReference<>() {});
            currencyCodes.addAll(currencyMap.keySet());
        } catch (IOException e) {
            System.err.println("Error reading currencies file: " + e.getMessage());
        }
        return currencyCodes;
    }

    @Override
    public Map<String, Double> fetchExchangeRates() {
        final Map<String, Double> exchangeRates = new HashMap<>();
        try {
            final String response = new String(Files.readAllBytes(Paths.get(exchangeRatesFilePath)));
            final Map<String, Object> jsonMap =  new ObjectMapper().readValue(response, new TypeReference<>() {});
            @SuppressWarnings("unchecked")
            final Map<String, Object> rates = (Map<String, Object>) jsonMap.get("rates");

            if (rates != null) {
                for (Map.Entry<String, Object> entry : rates.entrySet()) {
                    exchangeRates.put(entry.getKey(), ((Number) entry.getValue()).doubleValue());
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading currencies file: " + e.getMessage());
        }
        return exchangeRates;
    }
}

