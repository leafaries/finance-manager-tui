package com.leafaries.tui.archivedcode.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// TODO: Implement automatic refresh of the cached exchange rates every hour
public class ProductionCurrencyConverterModel extends AbstractCurrencyConverterModel {

    private static String APP_KEY;

    private ProductionCurrencyConverterModel() {
        Properties props = new Properties();
        Path envFile = Paths.get("/home/leafaries/IdeaProjects/finance-manager/finance-manager-old-version-archived/.env");
        try (var inputStream = Files.newInputStream(envFile)) {
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load enviroment variables from .env file", e);
        }
        String apiKey = props.getProperty("API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new RuntimeException("API_KEY not found in the .env file");
        }
        APP_KEY = apiKey;
    }

    @Override
    public List<String> availableCurrencies() {
        List<String> currencyCodes = new ArrayList<>();
        String endpoint = "https://openexchangerates.org/api/currencies.json";

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(endpoint).openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Reading response
                StringBuilder response = readResponse(connection);
                // Parsing JSON response to Map
                Map<String, String> currencyMap = new ObjectMapper().readValue(response.toString(), new TypeReference<>() {});
                currencyCodes.addAll(currencyMap.keySet()); // Extracting currency codes

            } else {
                System.out.println("GET request failed. Response Code: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currencyCodes;
    }

    @Override
    public Map<String, Double> fetchExchangeRates() {
        Map<String, Double> exchangeRates = new HashMap<>();
        String endpoint = "https://openexchangerates.org/api/latest.json?app_id=" + APP_KEY;

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(endpoint).openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                StringBuilder response = readResponse(connection);
                // Parse the JSON response to a Map
                Map<String, Object> jsonMap =  new ObjectMapper().readValue(response.toString(), new TypeReference<>() {});

                // Extracting rates
                @SuppressWarnings("unchecked")
                Map<String, Object> rates = (Map<String, Object>) jsonMap.get("rates");
                for (Map.Entry<String, Object> entry : rates.entrySet()) {
                    if (entry.getValue() instanceof Number) {
                        exchangeRates.put(entry.getKey(), ((Number) entry.getValue()).doubleValue());
                    }
                }
            } else {
                System.out.println("GET request failed. Response Code: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return exchangeRates;
    }

    private StringBuilder readResponse(HttpURLConnection connection) throws IOException {
        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
        return response;
    }
}

