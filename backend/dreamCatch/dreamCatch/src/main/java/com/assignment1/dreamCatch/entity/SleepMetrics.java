package com.assignment1.dreamCatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Objects;

@Entity
@DynamicUpdate
@CrossOrigin
@Table(name = "sleep_metrics")
public class SleepMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer durationLevel;
    private Integer energyLevel;
    private Integer stressLevel;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
     @JsonIgnore
    @JoinColumn(name = "dream_id")
    @MapsId
    private Dream dream;

    public SleepMetrics()
    {

    }
    public SleepMetrics(Long id, Integer durationLevel, Integer energyLevel, Integer stressLevel, Dream dream) {
        this.id = id;
        this.durationLevel = durationLevel;
        this.energyLevel = energyLevel;
        this.stressLevel = stressLevel;
        this.dream = dream;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDurationLevel() {
        return durationLevel;
    }

    public void setDurationLevel(Integer durationLevel) {
        this.durationLevel = durationLevel;
    }

    public Integer getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(Integer energyLevel) {
        this.energyLevel = energyLevel;
    }

    public Integer getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(Integer stressLevel) {
        this.stressLevel = stressLevel;
    }

    public Dream getDream() {
        return dream;
    }

    public void setDream(Dream dream) {
        this.dream = dream;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SleepMetrics that = (SleepMetrics) o;
        return id == that.id && durationLevel == that.durationLevel && energyLevel == that.energyLevel && stressLevel == that.stressLevel && Objects.equals(dream, that.dream);
    }

    @Override
    public String toString() {
        return "SleepMetrics{" +
                "id=" + id +
                ", durationLevel=" + durationLevel +
                ", energyLevel=" + energyLevel +
                ", stressLevel=" + stressLevel +
                ", dream=" + dream +
                '}';
    }
}
