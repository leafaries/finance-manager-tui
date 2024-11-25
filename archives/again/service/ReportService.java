package archives.again.service;

import archives.again.model.Report;
import archives.again.utils.HttpClient;

public class ReportService {
    private static final String REPORT_URL = "http://localhost:8080/reports";

    private final HttpClient httpClient;

    public ReportService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Report generateReport(String startDate, String endDate) {
        String reportRequest = "{\"startDate\": \"" + startDate + "\", \"endDate\": \"" + endDate + "\"}";
        String response = httpClient.post(REPORT_URL, reportRequest);
        return JsonParser.parseReport(response);
    }
}