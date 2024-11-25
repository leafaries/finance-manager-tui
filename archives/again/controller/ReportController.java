package archives.again.controller;

import archives.again.service.ReportService;
import archives.again.view.ReportView;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

    private final ReportService reportService;
    private final ReportView reportsView;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
        this.reportsView = new ReportView(this);
    }

    public void handleUserInput(KeyStroke keyStroke) {
        KeyType keyType = keyStroke.getKeyType();
        switch (keyType) {
            case Enter:
                LOGGER.info("Generating selected report.");
                reportsView.generateReport();
                break;
            case Escape:
                LOGGER.info("Returning to main menu.");
                break;
            default:
                LOGGER.warn("Unhandled key type: {}", keyType);
                break;
        }
    }

    public void start() {
        reportsView.show();
    }
}
