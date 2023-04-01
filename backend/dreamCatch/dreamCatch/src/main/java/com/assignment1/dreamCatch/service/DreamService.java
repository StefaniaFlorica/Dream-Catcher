package com.assignment1.dreamCatch.service;

import com.assignment1.dreamCatch.entity.Dream;
import com.assignment1.dreamCatch.entity.SleepMetrics;
import com.assignment1.dreamCatch.entity.Tag;
import com.assignment1.dreamCatch.repository.DreamRepo;
import com.assignment1.dreamCatch.repository.SleepMetricsRepo;
import com.assignment1.dreamCatch.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DreamService {

    @Autowired
    DreamRepo dreamRepo;
    @Autowired
    SleepMetricsRepo metricsRepo;
    @Autowired
    TagRepo tagRepo;

    public Dream saveDream(Dream dream) {
        Set<Tag> tags = dream.getTags();
        List<Tag> existingTags = tagRepo.findAll();
        Set<Tag> tagsToAdd = new HashSet<>();
        if (tags != null) {
            for (Tag tag : tags) {
                Optional<Tag> optionalTag = existingTags.stream().filter(t -> t.getName().equals(tag.getName())).findFirst();
                optionalTag.ifPresent(tagsToAdd::add);
            }
        }
        dream.setTags(tagsToAdd);
        dream.setDate(dream.getDate());
        dream.setTags(dream.getTags());
        return dreamRepo.save(dream);
    }

    public Dream updateDream(SleepMetrics metrics, Long id) {
        Dream dream = dreamRepo.getDreamById(id);
        dream.setSleepMetrics(metrics);
        return dreamRepo.save(dream);
    }
}
