package com.assignment1.dreamCatch.service.reportStrategy;

import com.assignment1.dreamCatch.service.reportFactory.DurationReport;
import com.assignment1.dreamCatch.service.reportFactory.EnergyReport;
import com.assignment1.dreamCatch.service.reportFactory.StressReport;

public class StrategyFactory {
    public ReportStrategy getInstance(String frequencyType) {
        return switch (frequencyType) {
            case "weekly" -> new WeeklyReport();
            case "monthly" -> new MonthlyReport();
            default -> new MonthlyReport();
        };
    }
}
