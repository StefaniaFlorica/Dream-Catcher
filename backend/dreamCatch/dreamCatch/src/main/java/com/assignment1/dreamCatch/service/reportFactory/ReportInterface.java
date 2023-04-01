package com.assignment1.dreamCatch.service.reportFactory;

import com.assignment1.dreamCatch.service.SleepMetricsService;

import java.util.Map;

public interface ReportInterface {
    public Map<Long, Float> generateReport(SleepMetricsService sleepMetricsService);
}
