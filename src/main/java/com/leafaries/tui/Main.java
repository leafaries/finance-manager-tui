package com.leafaries.tui;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//import com.leafaries.controller.CurrencyConverterController;
//import com.leafaries.model.AbstractCurrencyConverterModel;
//import com.leafaries.model.MockedCurrencyConverterModel;
//import com.leafaries.view.CurrencyConverterView;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Main {

    public static void main(String[] args) {
        try {
            TUI tui = new TUI(); // Initialize TUI
            Application app = new Application(tui.getGui()); // Initialize the application with TUI's GUI
            app.run(); // Run the application
            tui.cleanup(); // Clean up the screen
        } catch (Exception e) {
            e.printStackTrace();
        }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        // Initialize MVC components
//        AbstractCurrencyConverterModel model = new MockedCurrencyConverterModel();
//        CurrencyConverterView view = new CurrencyConverterView();
//        CurrencyConverterController controller = new CurrencyConverterController(model, view);
//
//        // Run the app
//        controller.run();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}

