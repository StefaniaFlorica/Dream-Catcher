package com.assignment1.dreamCatch.service.reportStrategy;

import com.assignment1.dreamCatch.entity.SleepMetrics;
import com.assignment1.dreamCatch.service.SleepMetricsService;

import java.util.List;

public class MonthlyReport implements ReportStrategy {
    @Override
    public List<SleepMetrics> execute(SleepMetricsService sleepMetricsService) {
        return sleepMetricsService.getSleepMetricsForLastMonth();
    }
}
