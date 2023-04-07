package com.assignment1.dreamCatch.repository;

import com.assignment1.dreamCatch.entity.Dream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DreamRepo extends JpaRepository<Dream, Long> {
    Dream save(Dream dream);
    Dream getDreamById(Long id);
}
