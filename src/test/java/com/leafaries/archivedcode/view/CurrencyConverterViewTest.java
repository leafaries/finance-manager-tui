package com.leafaries.archivedcode.view;

import com.googlecode.lanterna.gui2.ComboBox;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Button;

import com.leafaries.tui.archivedcode.view.CurrencyConverterView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CurrencyConverterViewTest {

    private CurrencyConverterView view;
    private ComboBox<String> fromCurrencyMock;
    private ComboBox<String> toCurrencyMock;
    private TextBox amountFieldMock;
    private Label resultLabelMock;
    private Button convertButtonMock;

    @BeforeEach
    public void setUp() {
        view = new CurrencyConverterView();

        // Mock components
        fromCurrencyMock = mock(ComboBox.class);
        toCurrencyMock = mock(ComboBox.class);
        amountFieldMock = mock(TextBox.class);
        resultLabelMock = mock(Label.class);
        convertButtonMock = mock(Button.class);

        // Inject mocks into the view
        view.setFromCurrency(fromCurrencyMock);
        view.setToCurrency(toCurrencyMock);
        view.setAmount(amountFieldMock);
        view.setResult(resultLabelMock);
        view.setConvertButton(convertButtonMock);
    }

    @Test
    public void testSetAvailableCurrencies() {
        // Given
        List<String> currencies = Arrays.asList("USD", "EUR", "JPY");

        // When
        view.setAvailableCurrencies(currencies);

        // Then
        assertEquals(currencies, view.getAvailableCurrencies());
    }

    @Test
    public void testGetFromCurrency() {
        // Given
        when(fromCurrencyMock.getSelectedItem()).thenReturn("USD");

        // When
        String fromCurrency = view.getFromCurrency();

        // Then
        assertEquals("USD", fromCurrency);
        verify(fromCurrencyMock).getSelectedItem();
    }

    @Test
    public void testGetToCurrency() {
        // Given
        when(toCurrencyMock.getSelectedItem()).thenReturn("EUR");

        // When
        String toCurrency = view.getToCurrency();

        // Then
        assertEquals("EUR", toCurrency);
        verify(toCurrencyMock).getSelectedItem();
    }

    @Test
    public void testGetAmount() {
        // Given
        when(amountFieldMock.getText()).thenReturn("100");

        // When
        String amount = view.getAmount();

        // Then
        assertEquals("100", amount);
        verify(amountFieldMock).getText();
    }

    @Test
    public void testSetResult() {
        // When
        view.setResult("Converted amount: 85 EUR");

        // Then
        verify(resultLabelMock).setText("Converted amount: 85 EUR");
    }

    @Test
    public void testConvertButtonListener() {
        // Given
        Runnable listenerMock = mock(Runnable.class);
        view.setConvertButtonListener(listenerMock);

        // When the convert button is clicked
        view.getConvertButton().takeFocus(); // Simulate clicking the convert button
        view.getConvertButtonListener().run();

        // Then
        verify(listenerMock).run();
    }
}

