package com.assignment1.dreamCatch.repository;

import com.assignment1.dreamCatch.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepo extends JpaRepository<Tag, Long> {
    List<Tag> findAll();
    Tag save(Tag tag);
//    Tag findBy(Long id);
}
