package archives.again.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Response object for fetching multiple wallets.
 */
public class WalletResponse {

    @JsonProperty("wallets")
    private List<Wallet> wallets;

    // Default constructor
    public WalletResponse() {
    }

    // Constructor
    public WalletResponse(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    // Getter
    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    @Override
    public String toString() {
        return "WalletResponse{wallets=" + wallets + "}";
    }
}