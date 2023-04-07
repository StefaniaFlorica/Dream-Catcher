package com.assignment1.dreamCatch.controller;

import com.assignment1.dreamCatch.entity.Dream;
import com.assignment1.dreamCatch.entity.SleepMetrics;
import com.assignment1.dreamCatch.service.DreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/dreamService")
public class DreamController {

    @Autowired
    private DreamService dreamService;

    @PostMapping("/saveDream")
    public Dream saveDream(@RequestBody Dream dream)
    {
        return dreamService.saveDream(dream);
    }

    @PutMapping("/updateDream/{id}")
    public Dream updateDreamMetrics( @RequestBody SleepMetrics metrics, @PathVariable Long id)
    {
        return dreamService.updateDream(metrics, id);
    }

}
