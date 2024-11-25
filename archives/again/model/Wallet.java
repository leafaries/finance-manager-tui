package archives.again.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a user's wallet containing information about its balance and associated transactions.
 */
public class Wallet {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("balance")
    private Double balance;

    @JsonProperty("currency")
    private String currency;

    // Default constructor
    public Wallet() {
    }

    // Constructor with fields
    public Wallet(Long id, String name, Double balance, String currency) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.currency = currency;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Wallet{id=" + id + ", name='" + name + "', balance=" + balance + ", currency='" + currency + "'}";
    }
}
