package com.assignment1.dreamCatch.repository;

import com.assignment1.dreamCatch.entity.SleepMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SleepMetricsRepo extends JpaRepository<SleepMetrics, Long> {
    SleepMetrics save(SleepMetrics sleepMetrics);

    List<SleepMetrics> findAll();

    @Query(value = "SELECT s.dream_id, s.duration_level, s.energy_level, s.stress_level FROM `dream-catch-schema`.sleep_metrics s INNER JOIN `dream-catch-schema`.dream d ON s.dream_id = d.id WHERE WEEKOFYEAR(d.date)=WEEKOFYEAR(CURDATE())-1", nativeQuery = true)
    List<SleepMetrics> findByWeek();

    @Query(value = "SELECT s.dream_id, s.duration_level, s.energy_level, s.stress_level FROM sleep_metrics s INNER JOIN dream d ON s.dream_id = d.id WHERE d.date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)", nativeQuery = true)
    List<SleepMetrics> findByMonth();
}
