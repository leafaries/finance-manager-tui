package archives.gpt.service;

import archives.gpt.model.User;

public class UserService {

    private static final String BASE_URL = "http://your-api-url/";

    // Simulate backend interaction, e.g., calling a database or external API
    public User registerUser(String username, String password) {
        // Make a POST request to the backend API to register the user
        // Returns a User object with the response data
        // In a real app, you would save the user to a database
        return new User(username, password);
    }

    public User loginUser(String username, String password) {
        // Make a POST request to the backend API to log in
        // Returns the logged-in User or null if authentication fails
        // Simulate backend authentication
        if ("validUser".equals(username) && "password123".equals(password)) {
            return new User(username, password);
        } else {
            return null;
        }
    }
}
