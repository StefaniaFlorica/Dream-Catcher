package com.assignment1.dreamCatch.service.reportStrategy;

import com.assignment1.dreamCatch.entity.SleepMetrics;
import com.assignment1.dreamCatch.service.SleepMetricsService;
import com.assignment1.dreamCatch.service.reportFactory.ReportFactory;
import com.assignment1.dreamCatch.service.reportFactory.ReportInterface;

import java.util.List;
import java.util.Map;

public class StrategyContext {
    ReportStrategy strategy;
    ReportFactory reportFactory;
    SleepMetricsService sleepMetricsService;

    public StrategyContext(ReportFactory reportFactory, SleepMetricsService sleepMetricsService) {
        this.reportFactory = reportFactory;
        this.sleepMetricsService = sleepMetricsService;
    }

    public void setStrategy(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    public Map<Long, Float> generateReportByMetric(String metricType) {
        List<SleepMetrics> sleepMetricsList = strategy.execute(sleepMetricsService);
        ReportInterface report = reportFactory.getInstance(metricType);
        return report.generateReport(sleepMetricsList, sleepMetricsService.getDreamRepo());
    }
}
