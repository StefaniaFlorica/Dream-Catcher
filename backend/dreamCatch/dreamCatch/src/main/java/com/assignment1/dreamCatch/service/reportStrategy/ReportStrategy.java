package com.assignment1.dreamCatch.service.reportStrategy;

import com.assignment1.dreamCatch.entity.SleepMetrics;
import com.assignment1.dreamCatch.service.SleepMetricsService;

import java.util.List;

public interface ReportStrategy {
    public List<SleepMetrics> execute(SleepMetricsService sleepMetricsService);
}
