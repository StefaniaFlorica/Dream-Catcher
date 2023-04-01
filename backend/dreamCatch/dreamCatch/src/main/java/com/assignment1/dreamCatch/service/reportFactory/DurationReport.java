package com.assignment1.dreamCatch.service.reportFactory;

import com.assignment1.dreamCatch.controller.SleepMetricsController;
import com.assignment1.dreamCatch.service.SleepMetricsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class DurationReport implements ReportInterface {

    @Override
    public Map<Long, Float> generateReport(SleepMetricsService sleepMetricsService) {
        return sleepMetricsService.getReport("duration");
    }
}
