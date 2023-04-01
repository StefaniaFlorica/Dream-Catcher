package com.assignment1.dreamCatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "dream")
@CrossOrigin
public class Dream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;
    private LocalDate date;


    @ManyToMany(cascade = CascadeType.MERGE)
    //@JsonIgnore
    @JoinTable(
            name = "dream_tag",
            joinColumns = @JoinColumn(name = "dream_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;


    @OneToOne(mappedBy = "dream", cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn //the primary key of the Dream entity is used as the foreign key value for the associated SleepMetrics entity.
    private SleepMetrics sleepMetrics;

    public Dream() {

    }

    public Dream(Long id, String description, LocalDate date, SleepMetrics sleepMetrics, Set<Tag> tags) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.sleepMetrics = sleepMetrics;
        this.tags = tags;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public SleepMetrics getSleepMetrics() {
        return sleepMetrics;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSleepMetrics(SleepMetrics sleepMetrics) {
        if (sleepMetrics == null) {
            if (this.sleepMetrics != null) {
                this.sleepMetrics.setDream(null);
            }
        } else {
            sleepMetrics.setDream(this);
        }
        this.sleepMetrics = sleepMetrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dream dream = (Dream) o;
        return Objects.equals(id, dream.id) && Objects.equals(description, dream.description) && Objects.equals(date, dream.date) && Objects.equals(tags, dream.tags) && Objects.equals(sleepMetrics, dream.sleepMetrics);
    }

    @Override
    public String toString() {
        return "Dream{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", tags=" + tags +
                ", sleepMetrics=" + sleepMetrics +
                '}';
    }
}
