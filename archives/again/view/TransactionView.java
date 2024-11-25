package archives.again.view;

import archives.again.controller.TransactionController;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;

import java.util.List;

public class TransactionView {
    private final TransactionController transactionController;
    private final MultiWindowTextGUI gui;

    public TransactionView(TransactionController transactionController, MultiWindowTextGUI gui) {
        this.transactionController = transactionController;
        this.gui = gui;
    }

    public void display(List<String> transactions) {
        BasicWindow window = new BasicWindow("Transaction History");
        Panel panel = new Panel();

        for (String transaction : transactions) {
            panel.addComponent(new Label(transaction));
        }

        panel.addComponent(new Button("Add Transaction", transactionController::onAddTransaction));
        panel.addComponent(new Button("Filter Transactions", transactionController::onFilterTransactions));
        panel.addComponent(new Button("Go Back", transactionController::onBack));

        window.setComponent(panel);
        gui.addWindowAndWait(window);
    }
}
