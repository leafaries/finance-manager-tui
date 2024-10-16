package com.leafaries.archivedcode.model;

import com.leafaries.tui.archivedcode.model.MockedCurrencyConverterModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MockedCurrencyConverterModelTest {

    private MockedCurrencyConverterModel model;

    @BeforeEach
    void setUp() {
        model = new MockedCurrencyConverterModel();
    }

    @Test
    void testAvailableCurrencies() {
        List<String> currencies = model.availableCurrencies();
        assertEquals(170, currencies.size()); // Adjust based on your test data
        assertEquals("AED", currencies.get(0)); // Adjust based on your test data
        assertEquals("AFN", currencies.get(1)); // Adjust based on your test data
    }

    @Test
    void testFetchExchangeRates() {
        Map<String, Double> rates = model.fetchExchangeRates();
        assertEquals(1.0, rates.get("USD"), 0.01);
        assertEquals(0.915329, rates.get("EUR"), 0.01);
    }

    @Test
    void testConvertFunctionality() {
        BigDecimal amount = new BigDecimal("100");
        BigDecimal convertedAmount = model.convert("USD", "EUR", amount);
        assertEquals(new BigDecimal("91.53"), convertedAmount.setScale(2, RoundingMode.HALF_UP));
    }
}

