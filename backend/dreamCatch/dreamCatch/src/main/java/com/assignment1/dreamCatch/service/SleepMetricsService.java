package com.assignment1.dreamCatch.service;

import com.assignment1.dreamCatch.entity.Dream;
import com.assignment1.dreamCatch.entity.SleepMetrics;
import com.assignment1.dreamCatch.repository.DreamRepo;
import com.assignment1.dreamCatch.repository.SleepMetricsRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SleepMetricsService {

    @Autowired
    SleepMetricsRepo sleepMetricsRepo;
    @Autowired
    DreamRepo dreamRepo;

    public SleepMetrics saveMetrics(SleepMetrics sleepMetrics, Long dream_id) {
        return sleepMetricsRepo.save(sleepMetrics);
    }

    public List<SleepMetrics> getSleepMetricsForLastMonth() {
        return sleepMetricsRepo.findByMonth();
    }

    public List<SleepMetrics> getSleepMetricsForLastWeek() {
        return sleepMetricsRepo.findByWeek();
    }

//    public Map<Long, Float> getReport(String metricOption) {
//        List<SleepMetrics> sleepMetricsList = sleepMetricsRepo.findAll();
//        Map<Long, List<Integer>> originalMap = new HashMap<>();
//        for (SleepMetrics sleepMetrics : sleepMetricsList) {
//            List<Integer> list;
//            Dream foundDream = dreamRepo.getDreamById(sleepMetrics.getId());
//            if (foundDream.getDate() == null) {
//                foundDream.setDate(LocalDate.now());
//            }
//            Long day = (long) foundDream.getDate().getDayOfWeek().getValue();
//            if (!originalMap.containsKey(day)) {
//                list = new ArrayList<>();
//
//            } else {
//                list = originalMap.get(day);
//            }
//
//            if (metricOption.equals("duration")) {
//                list.add(sleepMetrics.getDurationLevel());
//            } else if (metricOption.equals("energy")) {
//                list.add(sleepMetrics.getEnergyLevel());
//            } else {
//                list.add(sleepMetrics.getStressLevel());
//            }
//
//            originalMap.put(day, list);
//        }
//
//        return getAveragePerDayOfWeek(originalMap);
//    }

    public SleepMetricsRepo getSleepMetricsRepo() {
        return sleepMetricsRepo;
    }

    public void setSleepMetricsRepo(SleepMetricsRepo sleepMetricsRepo) {
        this.sleepMetricsRepo = sleepMetricsRepo;
    }

    public DreamRepo getDreamRepo() {
        return dreamRepo;
    }

    public void setDreamRepo(DreamRepo dreamRepo) {
        this.dreamRepo = dreamRepo;
    }
}
