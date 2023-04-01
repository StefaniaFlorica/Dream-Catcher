package com.assignment1.dreamCatch.controller;

import com.assignment1.dreamCatch.entity.SleepMetrics;
import com.assignment1.dreamCatch.service.SleepMetricsService;
import com.assignment1.dreamCatch.service.reportFactory.ReportFactory;
import com.assignment1.dreamCatch.service.reportFactory.ReportInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/metricsService")
public class SleepMetricsController {

    @Autowired
    SleepMetricsService sleepMetricsService;

    @PostMapping("/saveMetrics/{dream_id}")
    public SleepMetrics saveSleepMetrics(@RequestBody SleepMetrics sleepMetrics, @PathVariable Long dream_id) {
        return sleepMetricsService.saveMetrics(sleepMetrics, dream_id);
    }

    @GetMapping("/getReport/{reportType}")
    public Map<Long, Float> getReport(@PathVariable String reportType) {
        ReportInterface report = new ReportFactory().getInstance(reportType);
        return report.generateReport(sleepMetricsService);
    }
}
