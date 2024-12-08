package com.leafaries.tui.service;

import com.leafaries.tui.model.CategoryDto;
import com.leafaries.tui.model.CreateCategoryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {

    private final WebClient webClient;

    public void createCategory(CreateCategoryDto createCategoryDto) {
        // TODO: Implement
    }

    public void updateCategory(Long id, CreateCategoryDto createCategoryDto) {
        // TODO: Implement
    }

    public void deleteCategory(Long id) {
        // TODO: Implement
    }

    public List<CategoryDto> getAllCategories() {
        // TODO: Implement
        return null;
    }

    public CategoryDto getCategoryById(Long id) {
        // TODO: Implement
        return null;
    }

}
