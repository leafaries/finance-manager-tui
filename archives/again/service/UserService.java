package archives.again.service;

import archives.again.model.User;
import archives.again.utils.HttpClient;
import archives.again.utils.JsonParser;

public class UserService {
    private static final String LOGIN_URL = "http://localhost:8080/auth/login";

    private final HttpClient httpClient;

    public UserService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public User registerUser(User user) {
        String userJson = JsonParser.toJson(user);
        String response = httpClient.post(USER_URL + "/register", userJson);
        return JsonParser.parseUser(response);
    }

    public String loginUser(String username, String password) {
        String loginRequest = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
        return httpClient.post(LOGIN_URL, loginRequest); // Returns JWT token
    }
}