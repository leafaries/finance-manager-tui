package archives.again.service;

import archives.again.model.Transaction;
import archives.again.utils.HttpClient;
import archives.again.utils.JsonParser;

import java.util.List;

public class TransactionService {
    private static final String TRANSACTION_URL = "http://localhost:8080/api/transactions";

    private final HttpClient httpClient;

    public TransactionService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public List<Transaction> getTransactionsByWalletId(int walletId) {
        String response = httpClient.get(TRANSACTION_URL + "/wallet/" + walletId);
        return JsonParser.parseTransactionList(response);
    }

    public Transaction createTransaction(Transaction transaction) {
        String transactionJson = JsonParser.toJson(transaction);
        String response = httpClient.post(TRANSACTION_URL, transactionJson);
        return JsonParser.parseTransaction(response);
    }

    public void updateTransaction(Transaction transaction) {
        String transactionJson = JsonParser.toJson(transaction);
        httpClient.put(TRANSACTION_URL + "/" + transaction.getId(), transactionJson);
    }

    public void deleteTransaction(int transactionId) {
        httpClient.delete(TRANSACTION_URL + "/" + transactionId);
    }
}