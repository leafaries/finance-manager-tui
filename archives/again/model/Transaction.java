package archives.again.model;

import java.util.List;

public class Transaction {
    private List<Transaction> transactions;

    // Getter and Setter
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
