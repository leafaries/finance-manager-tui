package com.leafaries.tui.archivedcode.controller;

import com.leafaries.tui.archivedcode.model.AbstractCurrencyConverterModel;
import com.leafaries.tui.archivedcode.view.CurrencyConverterView;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverterController {

    private final AbstractCurrencyConverterModel model;
    private final CurrencyConverterView view;

    public CurrencyConverterController(AbstractCurrencyConverterModel model, CurrencyConverterView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        try {
            view.setConvertButtonListener(this::convertCurrency);
            view.setAvailableCurrencies(model.availableCurrencies());
            view.createUI();
        } catch (IOException e) {
            System.err.println("Encountered an IO error.");
            e.printStackTrace();
        }
    }

    public void convertCurrency() {
        // Get user input
        String fromCurrency = view.getFromCurrency();
        String toCurrency = view.getToCurrency();
        BigDecimal amount;

        // Handle invalid input amount
        try {
            amount = new BigDecimal(view.getAmount()).setScale(2, RoundingMode.DOWN);
        } catch (NumberFormatException e) {
            view.setResult("Invalid amount");
            return;
        }

        // Perform conversion
        BigDecimal convertedAmount = model.convert(fromCurrency, toCurrency, amount);
        view.setResult(String.format("%.2f %s", convertedAmount.doubleValue(), toCurrency));
    }
}

