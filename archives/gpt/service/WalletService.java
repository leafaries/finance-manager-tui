package archives.gpt.service;

import archives.gpt.model.Wallet;

import java.util.ArrayList;
import java.util.List;

public class WalletService {

    // Simulate backend interaction, e.g., retrieving data from a database
    public List<Wallet> getAllWallets() {
        // Send HTTP GET request to fetch all wallets
        List<Wallet> wallets = new ArrayList<>();
        wallets.add(new Wallet("again.Main Wallet", 1000.00, "USD"));
        wallets.add(new Wallet("Savings", 5000.00, "USD"));
        return wallets;
    }

    public Wallet createWallet(String name, double balance, String currency) {
        // Send HTTP POST request to create a new wallet
        // Simulate creating a wallet and saving it to a database
        return new Wallet(name, balance, currency);
    }
}
