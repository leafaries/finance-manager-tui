package archives.again.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(Validator.class);

    // Validates that a string is not null or empty
    public static boolean isNotEmpty(String input) {
        boolean isValid = input != null && !input.trim().isEmpty();
        LOGGER.debug("Validation - isNotEmpty: {} -> {}", input, isValid);
        return isValid;
    }

    // Validates that a string is a valid positive number
    public static boolean isPositiveNumber(String input) {
        try {
            double number = Double.parseDouble(input);
            boolean isValid = number > 0;
            LOGGER.debug("Validation - isPositiveNumber: {} -> {}", input, isValid);
            return isValid;
        } catch (NumberFormatException e) {
            LOGGER.warn("Validation - isPositiveNumber failed for input: {}", input);
            return false;
        }
    }

    // Validates that a string is a valid date in the format yyyy-MM-dd
    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            LOGGER.debug("Validation - isValidDate: {} -> true", date);
            return true;
        } catch (DateTimeParseException e) {
            LOGGER.warn("Validation - isValidDate failed for date: {}", date);
            return false;
        }
    }

    // Ensures a value is within a range (inclusive)
    public static boolean isWithinRange(double value, double min, double max) {
        boolean isValid = value >= min && value <= max;
        LOGGER.debug("Validation - isWithinRange: {} in [{}, {}] -> {}", value, min, max, isValid);
        return isValid;
    }

    // Validates an email address (simple regex)
    public static boolean isValidEmail(String email) {
        boolean isValid = email != null && email.matches("^[\\w-.]+@[\\w-]+\\.[a-z]{2,}$");
        LOGGER.debug("Validation - isValidEmail: {} -> {}", email, isValid);
        return isValid;
    }
}
