package com.assignment1.dreamCatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Objects;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Set<Dream> dreams;

    public Tag() {

    }

    public Tag(Long id, String name, Set<Dream> dreams) {
        this.id = id;
        this.name = name;
        this.dreams = dreams;
    }

    public Set<Dream> getDreams() {
        return dreams;
    }

    public void setDreams(Set<Dream> dreams) {
        this.dreams = dreams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id && name.equals(tag.name) && Objects.equals(dreams, tag.dreams);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'';
    }
}
