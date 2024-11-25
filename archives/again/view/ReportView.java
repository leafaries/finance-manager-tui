package archives.again.view;

import archives.again.controller.ReportController;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;

public class ReportView {
    private final ReportController reportController;
    private final MultiWindowTextGUI gui;

    public ReportView(ReportController reportController, MultiWindowTextGUI gui) {
        this.reportController = reportController;
        this.gui = gui;
    }

    public void display() {
        BasicWindow window = new BasicWindow("Generate Report");
        Panel panel = new Panel();

        panel.addComponent(new Button("Generate CSV Report", reportController::onGenerateCSV));
        panel.addComponent(new Button("Generate PDF Report", reportController::onGeneratePDF));
        panel.addComponent(new Button("Go Back", reportController::onBack));

        window.setComponent(panel);
        gui.addWindowAndWait(window);
    }
}