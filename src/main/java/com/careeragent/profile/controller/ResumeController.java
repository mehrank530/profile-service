package com.careeragent.profile.controller;

import com.careeragent.profile.entity.Resume;
import com.careeragent.profile.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/me/resumes/{profileId}")
    public ResponseEntity<String> uploadResume(
            @PathVariable Long profileId,
            @RequestParam("file") MultipartFile file) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(resumeService.uploadResume(profileId, file));
    }

    @GetMapping("/me/resumess/{profileId}")
    public ResponseEntity<List<Resume>> getAllResume(
            @PathVariable Long profileId) {

        return ResponseEntity.ok(
                resumeService.getAllResume(profileId)
        );
    }

    @GetMapping("/me/resumes/{resumeId}")
    public ResponseEntity<Resume> getByResumeId(
            @PathVariable Long resumeId) {

        return ResponseEntity.ok(
                resumeService.getByIdResume(resumeId)
        );
    }

    @PutMapping("/me/resumes/{resumeId}")
    public ResponseEntity<String> update(
            @PathVariable Long resumeId,
            @RequestBody Resume resume) {

        return ResponseEntity.ok(
                resumeService.update(resumeId, resume)
        );
    }

    @DeleteMapping("/me/resumes/{resumeId}")
    public ResponseEntity<String> delete(
            @PathVariable Long resumeId) {

        return ResponseEntity.ok(
                resumeService.delete(resumeId)
        );
    }

    @PatchMapping("/me/resumes/{resumeId}/primary")
    public ResponseEntity<String> setPrimaryResume(
            @PathVariable Long resumeId) {

        return ResponseEntity.ok(
                resumeService.setPrimaryResume(resumeId)
        );
    }
}