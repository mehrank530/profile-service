package com.careeragent.profile.controller;

import com.careeragent.profile.entity.Education;
import com.careeragent.profile.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @PostMapping("/me/education")
    public ResponseEntity<String> create(
            @RequestBody Education education) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(educationService.create(education));
    }

    @GetMapping("/me/education")
    public ResponseEntity<List<Education>> getAllEducation(){
        return ResponseEntity.ok(
                educationService.getAllEducation());
    }

    @GetMapping("/me/education/{educationId}")
    public ResponseEntity<Education> getByEducation(
            @PathVariable Long educationId) {
        return ResponseEntity.ok(
                educationService.getById(educationId));
    }
    @PutMapping("/me/education/{educationId}")
    public ResponseEntity<String> update(
            @PathVariable Long educationId,
            @RequestBody Education education) {

        return ResponseEntity.ok(
                educationService.update(educationId, education)
        );
    }

    @DeleteMapping("/me/education/{educationId}")
    public ResponseEntity<String> delete(
            @PathVariable Long educationId) {

        return ResponseEntity.ok(
                educationService.delete(educationId));
    }


}
