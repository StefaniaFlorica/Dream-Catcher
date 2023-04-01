package com.assignment1.dreamCatch.controller;

import com.assignment1.dreamCatch.entity.SleepMetrics;
import com.assignment1.dreamCatch.service.SleepMetricsService;
import com.assignment1.dreamCatch.service.reportFactory.ReportFactory;
import com.assignment1.dreamCatch.service.reportFactory.ReportInterface;
import com.assignment1.dreamCatch.service.reportStrategy.ReportStrategy;
import com.assignment1.dreamCatch.service.reportStrategy.StrategyContext;
import com.assignment1.dreamCatch.service.reportStrategy.StrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    @GetMapping("/getReport/{frequencyType}/{metricType}")
    public Map<Long, Float> getReport(@PathVariable String frequencyType, @PathVariable String metricType) {
        StrategyContext strategyContext = new StrategyContext(new ReportFactory(), sleepMetricsService);
        ReportStrategy strategy = new StrategyFactory().getInstance(frequencyType);
        strategyContext.setStrategy(strategy);
        return strategyContext.generateReportByMetric(metricType);
    }
}
