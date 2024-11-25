package archives.again;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BackendService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackendService.class);
    private static final String BASE_URL = "http://localhost:8080/";

    private String jwtToken;
    private OkHttpClient client;
    private ObjectMapper objectMapper;

    public BackendService() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    private Response executeRequest(Request request) throws IOException {
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.error("Request failed: {} {}", request.url(), response.code());
                throw new IOException("Unexpected code " + response);
            }
            return response;
        } catch (IOException e) {
            logger.error("Error executing request: {}", e.getMessage());
            throw new RuntimeException("Error executing request", e);
        }
    }
}
