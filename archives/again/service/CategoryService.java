package archives.again.service;

import archives.again.model.CategoryResponse;
import archives.again.utils.HttpClient;
import archives.again.utils.JsonParser;

import java.util.List;

public class CategoryService {
    private static final String CATEGORY_URL = "http://localhost:8080/categories";

    private final HttpClient httpClient;

    public CategoryService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public List<CategoryResponse> getAllCategories() {
        String response = httpClient.get(CATEGORY_URL);
        return JsonParser.parseCategoryList(response);
    }

    public CategoryResponse createCategory(CategoryResponse categoryResponse) {
        String categoryJson = JsonParser.toJson(categoryResponse);
        String response = httpClient.post(CATEGORY_URL, categoryJson);
        return JsonParser.parseCategory(response);
    }

    public void updateCategory(CategoryResponse categoryResponse) {
        String categoryJson = JsonParser.toJson(categoryResponse);
        httpClient.put(CATEGORY_URL + "/" + categoryResponse.getId(), categoryJson);
    }

    public void deleteCategory(int categoryId) {
        httpClient.delete(CATEGORY_URL + "/" + categoryId);
    }
}
