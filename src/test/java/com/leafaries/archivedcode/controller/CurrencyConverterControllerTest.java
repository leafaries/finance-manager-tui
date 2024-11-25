//package com.leafaries.archivedcode.controller;
//
//import com.leafaries.tui.archivedcode.model.AbstractCurrencyConverterModel;
//import com.leafaries.tui.archivedcode.controller.CurrencyConverterController;
//import com.leafaries.tui.archivedcode.view.CurrencyConverterView;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class CurrencyConverterControllerTest {
//
//    private AbstractCurrencyConverterModel mockModel;
//    private CurrencyConverterView mockView;
//    private CurrencyConverterController controller;
//
//    @BeforeEach
//    void setUp() {
//        mockModel = mock(AbstractCurrencyConverterModel.class);
//        mockView = mock(CurrencyConverterView.class);
//        controller = new CurrencyConverterController(mockModel, mockView);
//    }
//
//    @Test
//    void testRunSetsUpViewCorrectly() throws IOException {
//        // Arrange
//        when(mockModel.availableCurrencies()).thenReturn(List.of(new String[]{"USD", "EUR"}));
//
//        // Act
//        controller.run();
//
//        // Assert
//        verify(mockView).setConvertButtonListener(any());
//        verify(mockView).setAvailableCurrencies(List.of(new String[]{"USD", "EUR"}));
//        verify(mockView).createUI();
//    }
//
//    @Test
//    void testConvertCurrencyValidInput() {
//        // Arrange
//        when(mockView.getFromCurrency()).thenReturn("USD");
//        when(mockView.getToCurrency()).thenReturn("EUR");
//        when(mockView.getAmount()).thenReturn("100");
//        when(mockModel.convert("USD", "EUR", new BigDecimal("100.00")))
//                .thenReturn(new BigDecimal("85.00"));
//
//        // Act
//        controller.run(); // Initialize the UI setup
//        controller.convertCurrency(); // Directly call convertCurrency for testing
//
//        // Assert
//        ArgumentCaptor<String> resultCaptor = ArgumentCaptor.forClass(String.class);
//        verify(mockView).setResult(resultCaptor.capture());
//        assertEquals("85.00 EUR", resultCaptor.getValue());
//    }
//
//    @Test
//    void testConvertCurrencyInvalidAmount() {
//        // Arrange
//        when(mockView.getFromCurrency()).thenReturn("USD");
//        when(mockView.getToCurrency()).thenReturn("EUR");
//        when(mockView.getAmount()).thenReturn("invalid"); // Invalid input
//
//        // Act
//        controller.run(); // Initialize the UI setup
//        controller.convertCurrency(); // Directly call convertCurrency for testing
//
//        // Assert
//        verify(mockView).setResult("Invalid amount");
//    }
//
//    @Test
//    void testRunHandlesIOException() throws IOException {
//        // Arrange
//        doThrow(new IOException("IO error")).when(mockView).createUI();
//
//        // Act
//        controller.run(); // This should not throw an exception
//
//        // Assert
//        // We can verify if the error message is printed
//        // (in a real-world test, you might want to capture System.err output)
//    }
//}
//
