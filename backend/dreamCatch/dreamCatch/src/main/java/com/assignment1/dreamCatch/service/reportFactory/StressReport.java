package com.assignment1.dreamCatch.service.reportFactory;

import com.assignment1.dreamCatch.entity.Dream;
import com.assignment1.dreamCatch.entity.SleepMetrics;
import com.assignment1.dreamCatch.repository.DreamRepo;
import com.assignment1.dreamCatch.repository.SleepMetricsRepo;
import com.assignment1.dreamCatch.service.SleepMetricsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StressReport implements ReportInterface {
    @Override
    public Map<Long, Float> generateReport(List<SleepMetrics> sleepMetricsList, DreamRepo dreamRepo) {
        Map<Long, List<Integer>> originalMap = new HashMap<>();
        for (SleepMetrics sleepMetrics : sleepMetricsList) {
            List<Integer> list;
            Dream foundDream = dreamRepo.getDreamById(sleepMetrics.getId());
            if (foundDream.getDate() == null) {
                foundDream.setDate(LocalDate.now());
            }
            Long day = (long) foundDream.getDate().getDayOfWeek().getValue();
            if (!originalMap.containsKey(day)) {
                list = new ArrayList<>();

            } else {
                list = originalMap.get(day);
            }
            list.add(sleepMetrics.getStressLevel());
            originalMap.put(day, list);
        }

        return getAveragePerDayOfWeek(originalMap);
    }
}

