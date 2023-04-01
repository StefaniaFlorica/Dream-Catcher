package com.assignment1.dreamCatch.repository;

import com.assignment1.dreamCatch.entity.SleepMetrics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SleepMetricsRepo extends JpaRepository<SleepMetrics, Long> {
    SleepMetrics save(SleepMetrics sleepMetrics);
    List<SleepMetrics> findAll();
}
