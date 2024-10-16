package com.leafaries.archivedcode.model;

import com.leafaries.tui.archivedcode.model.AbstractCurrencyConverterModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class AbstractCurrencyConverterModelTest {

    // Concrete subclass for testing purposes
    private class TestCurrencyConverterModel extends AbstractCurrencyConverterModel {
        private final boolean mockFetchExchangeRates;

        public TestCurrencyConverterModel(boolean mockFetchExchangeRates) {
            this.mockFetchExchangeRates = mockFetchExchangeRates;
            if (mockFetchExchangeRates) {
                exchangeRates = new HashMap<>(); // Initalizes with an empty map for mocking
            }
        }

        @Override
        public List<String> availableCurrencies() {
            return List.of("USD", "EUR", "JPY");
        }

        @Override
        public Map<String, Double> fetchExchangeRates() {
            // Mock exchange rates for testing
            Map<String, Double> rates = new HashMap<>();
            rates.put("USD", 1.0);
            rates.put("EUR", 0.85);
            rates.put("JPY", 110.0);
            return rates;
        }
    }

    private TestCurrencyConverterModel model;

    @BeforeEach
    void setUp() {
        model = new TestCurrencyConverterModel(true);
    }

    @AfterEach
    void tearDown() {
        // Shutdown the scheduler to avoid any background task issues
        model.scheduler.shutdownNow();
    }

    @Test
    void testAvailableCurrencies() {
        List<String> expectedCurrencies = List.of("USD", "EUR", "JPY");
        assertEquals(expectedCurrencies, model.availableCurrencies());
    }

    @Test
    void testFetchExchangeRates() {
        Map<String, Double> expectedRates = new HashMap<>();
        expectedRates.put("USD", 1.0);
        expectedRates.put("EUR", 0.85);
        expectedRates.put("JPY", 110.0);

        assertEquals(expectedRates, model.fetchExchangeRates());
    }

    @Test
    void testConvertWithValidInput() {
        BigDecimal amount = new BigDecimal("100");
        model.exchangeRates = model.fetchExchangeRates();
        BigDecimal convertedAmount = model.convert("USD", "EUR", amount);
        // 100 USD to EUR with a rate of 0.85
        assertEquals(new BigDecimal("85.000000"), convertedAmount);
    }

    @Test
    void testConvertWithEmptyExchangeRates() {
        // Clear the exchange rates to test this scenario
        model.exchangeRates = Collections.emptyMap();
        BigDecimal amount = new BigDecimal("100");
        BigDecimal convertedAmount = model.convert("USD", "EUR", amount); // Sometimes returns 0???
        // When exchange rates are empty, the conversion should return 0
        assertEquals(BigDecimal.ZERO, convertedAmount);
    }
}

