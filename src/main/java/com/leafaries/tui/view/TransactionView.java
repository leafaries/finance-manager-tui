package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;
import org.springframework.stereotype.Component;

@Component
public class TransactionView {
    private final WindowBasedTextGUI gui;

    public TransactionView(WindowBasedTextGUI gui) {
        this.gui = gui;
    }

    public void show() {
        BasicWindow window = new BasicWindow("Record Transaction");
        Panel transactionPanel = new Panel(new GridLayout(2));

        transactionPanel.addComponent(new Label("Amount:"));
        TextBox amountField = new TextBox();
        transactionPanel.addComponent(amountField);

        transactionPanel.addComponent(new Label("Date (YYYY-MM-DD):"));
        TextBox dateField = new TextBox();
        transactionPanel.addComponent(dateField);

        transactionPanel.addComponent(new Label("Category:"));
        TextBox categoryField = new TextBox();
        transactionPanel.addComponent(categoryField);

        transactionPanel.addComponent(new Label("Notes (optional):"));
        TextBox notesField = new TextBox();
        transactionPanel.addComponent(notesField);

        transactionPanel.addComponent(new Button("Save", () -> {
            // Implement backend API call to save transaction
            window.close();
        }));

        window.setComponent(transactionPanel);
        gui.addWindowAndWait(window);
    }
}
