package com.assignment1.dreamCatch.service.reportFactory;

public class ReportFactory {
    public ReportInterface getInstance(String reportType) {
        return switch (reportType) {
            case "duration" -> new DurationReport();
            case "energy" -> new EnergyReport();
            case "stress" -> new StressReport();
            default -> new StressReport();
        };
    }
}
