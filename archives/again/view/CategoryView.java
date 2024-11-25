package archives.again.view;

import archives.again.controller.CategoryController;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;

import java.util.List;

public class CategoryView {
    private final CategoryController categoryController;
    private final MultiWindowTextGUI gui;

    public CategoryView(CategoryController categoryController, MultiWindowTextGUI gui) {
        this.categoryController = categoryController;
        this.gui = gui;
    }

    public void display(List<String> categories) {
        BasicWindow window = new BasicWindow("Category Management");
        Panel panel = new Panel();

        for (String category : categories) {
            panel.addComponent(new Button(category, () -> categoryController.onCategorySelected(category)));
        }

        panel.addComponent(new Button("Add Category", categoryController::onAddCategory));
        panel.addComponent(new Button("Go Back", categoryController::onBack));

        window.setComponent(panel);
        gui.addWindowAndWait(window);
    }
}