package archives.again.service;

import archives.again.model.Wallet;
import archives.again.utils.HttpClient;
import archives.again.utils.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WalletService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WalletService.class);
    private static final String WALLET_URL = "http://localhost:8080/api/wallets";

    private final HttpClient httpClient;

    public WalletService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Wallet createWallet(Wallet wallet) {
        String walletJson = JsonParser.toJson(wallet);
        String response = httpClient.post(WALLET_URL, walletJson);
        return JsonParser.parseWallet(response);
    }

    public List<Wallet> getAllWallets() {
        String response = httpClient.get(WALLET_URL);
        return JsonParser.parseWalletList(response);
    }

    public Wallet getWalletById(int walletId) {
        String response = httpClient.get(WALLET_URL + "/" + walletId);
        return JsonParser.parseWallet(response);
    }

    public void updateWallet(Wallet wallet) {
        String walletJson = JsonParser.toJson(wallet);
        httpClient.put(WALLET_URL + "/" + wallet.getId(), walletJson);
    }

    public void deleteWallet(int walletId) {
        httpClient.delete(WALLET_URL + "/" + walletId);
    }
}
