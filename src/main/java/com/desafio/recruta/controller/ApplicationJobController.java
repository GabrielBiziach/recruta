package com.desafio.recruta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.recruta.entity.ApplicationJob;
import com.desafio.recruta.service.ApplicationJobService;

@RestController
@RequestMapping("/api/applicationJob")
public class ApplicationJobController {

    @Autowired
    private ApplicationJobService applicationJobService;

    @GetMapping
    public List<ApplicationJob> getAllApplications() {
        return applicationJobService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationJob> getApplicationById(@PathVariable Long id) {
        return applicationJobService.findById(id)
                .map(application -> ResponseEntity.ok().body(application))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ApplicationJob createApplication(@RequestBody ApplicationJob application) {
        return applicationJobService.createApplication(application);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationJob> updateApplication(@PathVariable Long id, @RequestBody ApplicationJob applicationDetails) {
        return ResponseEntity.ok(applicationJobService.updateApplication(id, applicationDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationJobService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
