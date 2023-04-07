package com.assignment1.dreamCatch.controller;

import com.assignment1.dreamCatch.entity.Tag;
import com.assignment1.dreamCatch.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/tagService")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping("/saveTag")
    public Tag saveTag(@RequestBody Tag tag)
    {
        return tagService.save(tag);
    }

    @GetMapping("/getTags")
    public List<Tag> getTags()
    {
        return tagService.getTags();
    }

//    @GetMapping("/getTag/{id}")
//    public Tag getTagById(@PathVariable Long id)
//    {
//        return tagService.getTagById(id);
//    }
}
