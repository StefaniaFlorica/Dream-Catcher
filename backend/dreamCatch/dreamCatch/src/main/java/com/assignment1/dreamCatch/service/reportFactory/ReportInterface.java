package com.assignment1.dreamCatch.service.reportFactory;

import com.assignment1.dreamCatch.entity.SleepMetrics;
import com.assignment1.dreamCatch.repository.DreamRepo;
import com.assignment1.dreamCatch.service.SleepMetricsService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ReportInterface {
    public Map<Long, Float> generateReport(List<SleepMetrics> sleepMetricsList, DreamRepo dreamRepo);

    public default Map<Long, Float> getAveragePerDayOfWeek(Map<Long, List<Integer>> originalMap) {
        return originalMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            List<Integer> values = entry.getValue();
                            float sum = 0;
                            for (int value : values) {
                                sum += value;
                            }
                            return sum / values.size();
                        }
                ));
    }
}
