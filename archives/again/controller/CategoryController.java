package archives.again.controller;

import archives.again.service.CategoryService;
import archives.again.view.CategoryView;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryService categoryService;
    private final CategoryView categoryView;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
        this.categoryView = new CategoryView(this);
    }

    public void handleUserInput(KeyStroke keyStroke) {
        KeyType keyType = keyStroke.getKeyType();

        switch (keyType) {
            case ArrowUp:
                categoryView.navigateUp();
                break;
            case ArrowDown:
                categoryView.navigateDown();
                break;
            case Enter:
                String selectedCategory = categoryView.getSelectedOption();
                LOGGER.info("Selected category: {}", selectedCategory);
                // Perform actions like editing the category
                break;
            case Character:
                if (keyStroke.getCharacter() == 'n') {
                    LOGGER.info("Adding a new category.");
                    categoryView.addCategory();
                } else if (keyStroke.getCharacter() == 'd') {
                    LOGGER.info("Deleting the selected category.");
                    categoryView.deleteCategory();
                }
                break;
            case Escape:
                LOGGER.info("Returning to main menu.");
                return;
            default:
                LOGGER.warn("Unhandled key type: {}", keyType);
                break;
        }    }

    private void createNewCategory() {
        // Call service to create a new category and refresh the view
        categoryService.createCategory("New Category");
        categoryView.refresh();
    }

    public void start() {
        categoryView.show();
    }
}
