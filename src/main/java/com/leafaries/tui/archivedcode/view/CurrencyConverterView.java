package com.leafaries.tui.archivedcode.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CurrencyConverterView {

    private ComboBox<String> fromCurrency;
    private ComboBox<String> toCurrency;
    private TextBox amountField;
    private Label resultLabel;
    private Button convertButton;
    private Runnable convertButtonListener;
    private List<String> availableCurrencies;

    public void setConvertButtonListener(Runnable convertButtonListener) {
        this.convertButtonListener = convertButtonListener;
    }

    public void createUI() throws IOException {
        // Create screen
        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();

        // Create text GUI
        WindowBasedTextGUI gui = new MultiWindowTextGUI(screen);

        // Create window
        BasicWindow window = new BasicWindow("Currency Converter");
        window.setHints(Collections.singletonList(Window.Hint.CENTERED));

        // Panel containing the form
        Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));

        // Create panel
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2)); // 2 columns

        // Add input field for amount
        panel.addComponent(new Label("Amount:"));
        amountField = new TextBox();
        panel.addComponent(amountField);

        // Add ComboBox for source currency
        panel.addComponent(new Label("From Currency:"));
        fromCurrency = new ComboBox<>(availableCurrencies);
        panel.addComponent(fromCurrency);

        // Add ComboBox for target currency
        panel.addComponent(new Label("To Currency:"));
        toCurrency = new ComboBox<>(availableCurrencies);
        panel.addComponent(toCurrency);

        // Add a switch button to swap currencies
        Button switchButton = new Button("Switch", () -> {
            String selectedFrom = fromCurrency.getSelectedItem();
            String selectedTo = toCurrency.getSelectedItem();

            // Swap the selected items
            fromCurrency.setSelectedItem(selectedTo);
            toCurrency.setSelectedItem(selectedFrom);
        });
        panel.addComponent(new Label(""));
        panel.addComponent(switchButton);

        // Add label to show the result
        panel.addComponent(new Label("Converted Amount:"));
        resultLabel = new Label("");
        panel.addComponent(resultLabel);

        panel.addComponent(new Label(""));

        // Add the convert button
        convertButton = new Button("Convert", () -> {
            if (convertButtonListener != null) {
                convertButtonListener.run(); // Invoke the controller logic when clicked
            }
        });
        panel.addComponent(convertButton);

        // Set styling for resultLabel
        resultLabel.setForegroundColor(TextColor.ANSI.GREEN);

        // Set window content and add it to the text GUI
        mainPanel.addComponent(panel);

        window.setComponent(mainPanel);
        gui.addWindow(window);
        window.waitUntilClosed(); // This will block until the window is closed

        screen.stopScreen(); // Close the screen properly when the app exits
    }

    public List<String> getAvailableCurrencies() {
        return availableCurrencies;
    }

    public void setAvailableCurrencies(List<String> availableCurrencies) {
        this.availableCurrencies = availableCurrencies;
    }

    public void setResult(String result) {
        resultLabel.setText(result);
    }

    public String getFromCurrency() {
        return fromCurrency.getSelectedItem();
    }

    public void setFromCurrency(ComboBox<String> fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency.getSelectedItem();
    }

    public void setToCurrency(ComboBox<String> toCurrency) {
        this.toCurrency = toCurrency;
    }

    public String getAmount() {
        return amountField.getText();
    }

    public void setAmount(TextBox amountField) {
        this.amountField = amountField;
    }

    public Label getResultLabel() {
        return resultLabel;
    }

    public void setResult(Label resultLabel) {
        this.resultLabel = resultLabel;
    }

    public Button getConvertButton() {
        return convertButton;
    }

    public void setConvertButton(Button convertButton) {
        this.convertButton = convertButton;
    }

    public Runnable getConvertButtonListener() {
        return convertButtonListener;
    }
}

