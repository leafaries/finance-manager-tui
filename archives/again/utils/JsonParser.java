package archives.again.utils;

import archives.again.model.CategoryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class JsonParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonParser.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /*
    // Serialize Java object to JSON string
    public static String toJson(Object object) {
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            LOGGER.debug("Serialized object to JSON: {}", jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            LOGGER.error("Error serializing object to JSON: {}", object, e);
            throw new RuntimeException("Serialization error", e);
        }
    }

    // Deserialize JSON string to a Java object
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            T object = objectMapper.readValue(json, clazz);
            LOGGER.debug("Deserialized JSON to object: {}", object);
            return object;
        } catch (IOException e) {
            LOGGER.error("Error deserializing JSON: {}", json, e);
            throw new RuntimeException("Deserialization error", e);
        }
    }

    // Deserialize JSON string to a List of Java objects
    public static <T> List<T> fromJsonList(String json, Class<T> clazz) {
        try {
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            List<T> list = objectMapper.readValue(json, listType);
            LOGGER.debug("Deserialized JSON to List: {}", list);
            return list;
        } catch (IOException e) {
            LOGGER.error("Error deserializing JSON to List: {}", json, e);
            throw new RuntimeException("Deserialization error", e);
        }
    }
     */
    // Deserialize JSON string into Category object
    public static CategoryResponse parseCategory(String json) {
        try {
            return objectMapper.readValue(json, CategoryResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing Category", e);
        }
    }

    // Deserialize JSON string into CategoryResponse object
    public static CategoryResponse parseCategoryResponse(String json) {
        try {
            return objectMapper.readValue(json, CategoryResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing CategoryResponse", e);
        }
    }

    // Deserialize JSON string into Report object
    public static Report parseReport(String json) {
        try {
            return objectMapper.readValue(json, Report.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing Report", e);
        }
    }

    // Deserialize JSON string into ReportResponse object
    public static ReportResponse parseReportResponse(String json) {
        try {
            return objectMapper.readValue(json, ReportResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing ReportResponse", e);
        }
    }

    // Deserialize JSON string into Transaction object
    public static Transaction parseTransaction(String json) {
        try {
            return objectMapper.readValue(json, Transaction.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing Transaction", e);
        }
    }

    // Deserialize JSON string into TransactionResponse object
    public static TransactionResponse parseTransactionResponse(String json) {
        try {
            return objectMapper.readValue(json, TransactionResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing TransactionResponse", e);
        }
    }

    // Deserialize JSON string into User object
    public static User parseUser(String json) {
        try {
            return objectMapper.readValue(json, User.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing User", e);
        }
    }

    // Deserialize JSON string into UserResponse object
    public static UserResponse parseUserResponse(String json) {
        try {
            return objectMapper.readValue(json, UserResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing UserResponse", e);
        }
    }

    // Deserialize JSON string into Wallet object
    public static Wallet parseWallet(String json) {
        try {
            return objectMapper.readValue(json, Wallet.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing Wallet", e);
        }
    }

    // Deserialize JSON string into WalletResponse object
    public static WalletResponse parseWalletResponse(String json) {
        try {
            return objectMapper.readValue(json, WalletResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing WalletResponse", e);
        }
    }

    // Serialize an object to JSON string
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException("Error converting object to JSON", e);
        }
    }

    // Deserialize JSON string into a generic object (useful for lists or other unknown structures)
    public static <T> T fromJson(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON to object", e);
        }
    }

    // Deserialize JSON string into a generic list (useful for lists of any object type)
    public static <T> java.util.List<T> fromJsonList(String json, TypeReference<java.util.List<T>> typeReference) {
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON to list", e);
        }
    }
}
