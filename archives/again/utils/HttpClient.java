package archives.again.utils;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class HttpClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClient.class);
    private static final OkHttpClient client = new OkHttpClient();
    private static final String BASE_URL = "http://localhost:8080/"; // Replace with your backend URL
    private static String authToken = null; // Holds the JWT token after login

    // Method to set the authentication token
    public static void setAuthToken(String token) {
        authToken = token;
        LOGGER.info("Authentication token set.");
    }

    // General GET request
    public static String get(String endpoint) throws IOException {
        Request.Builder requestBuilder = new Request.Builder()
                .url(BASE_URL + endpoint)
                .get();
        addAuthorizationHeader(requestBuilder);

        Request request = requestBuilder.build();
        LOGGER.info("Sending GET request to {}", request.url());
        return executeRequest(request);
    }

    // General POST request
    public static String post(String endpoint, String jsonBody) throws IOException {
        RequestBody body = RequestBody.create(jsonBody, MediaType.get("application/json"));
        Request.Builder requestBuilder = new Request.Builder()
                .url(BASE_URL + endpoint)
                .post(body);
        addAuthorizationHeader(requestBuilder);

        Request request = requestBuilder.build();
        LOGGER.info("Sending POST request to {}", request.url());
        return executeRequest(request);
    }

    // General PUT request
    public static String put(String endpoint, String jsonBody) throws IOException {
        RequestBody body = RequestBody.create(jsonBody, MediaType.get("application/json"));
        Request.Builder requestBuilder = new Request.Builder()
                .url(BASE_URL + endpoint)
                .put(body);
        addAuthorizationHeader(requestBuilder);

        Request request = requestBuilder.build();
        LOGGER.info("Sending PUT request to {}", request.url());
        return executeRequest(request);
    }

    // General DELETE request
    public static String delete(String endpoint) throws IOException {
        Request.Builder requestBuilder = new Request.Builder()
                .url(BASE_URL + endpoint)
                .delete();
        addAuthorizationHeader(requestBuilder);

        Request request = requestBuilder.build();
        LOGGER.info("Sending DELETE request to {}", request.url());
        return executeRequest(request);
    }

    // Adds Authorization header if authToken is set
    private static void addAuthorizationHeader(Request.Builder requestBuilder) {
        if (authToken != null) {
            requestBuilder.addHeader("Authorization", "Bearer " + authToken);
        }
    }

    // Executes the request and handles the response
    private static String executeRequest(Request request) throws IOException {
        try (Response response = client.newCall(request).execute()) {
            int statusCode = response.code();
            LOGGER.info("Received response with status code: {}", statusCode);

            if (!response.isSuccessful()) {
                LOGGER.error("Request failed with status code: {} and message: {}", statusCode, response.message());
                throw new IOException("Unexpected code " + statusCode + ": " + response.message());
            }

            String responseBody = response.body().string();
            LOGGER.debug("Response body: {}", responseBody);
            return responseBody;
        }
    }

    // Optional: Add query parameters to a URL
    public static String addQueryParams(String url, Map<String, String> queryParams) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
        }
        return urlBuilder.build().toString();
    }
}
