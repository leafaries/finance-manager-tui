package archives.tui.archivedcode.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractCurrencyConverterModel {

    protected static final String currenciesFilePath = "/home/leafaries/IdeaProjects/finance-manager/finance-manager-old-version-archived/src/main/resources/api_response_currencies.txt";
    protected static final String exchangeRatesFilePath = "/home/leafaries/IdeaProjects/finance-manager/finance-manager-old-version-archived/src/main/resources/api_response_latest.txt";
    protected final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    protected Map<String, Double> exchangeRates = fetchExchangeRates();

    protected AbstractCurrencyConverterModel() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                exchangeRates = fetchExchangeRates();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.HOURS);
    }

    public abstract List<String> availableCurrencies();

    public abstract Map<String, Double> fetchExchangeRates();

    public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount) {
        if (exchangeRates.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal rateOfSource = BigDecimal.valueOf(exchangeRates.get(fromCurrency));
        BigDecimal rateOfTarget = BigDecimal.valueOf(exchangeRates.get(toCurrency));

        return amount.multiply(rateOfTarget).divide(rateOfSource, 6, RoundingMode.HALF_UP);
    }
}

