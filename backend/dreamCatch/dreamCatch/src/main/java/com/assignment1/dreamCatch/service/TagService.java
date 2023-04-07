package com.assignment1.dreamCatch.service;

import com.assignment1.dreamCatch.entity.Tag;
import com.assignment1.dreamCatch.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    TagRepo tagRepo;

    public Tag save(Tag tag)
    {
        return tagRepo.save(tag);
    }

//    public Tag getTagById(Long id)
//    {
//        return tagRepo.findBy(id);
//    }

    public List<Tag> getTags()
    {
        return tagRepo.findAll();
    }

}