package com.careeragent.profile.controller;

import com.careeragent.profile.entity.Profile;
import com.careeragent.profile.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/profiles")
    public ResponseEntity<String> create(
            @RequestBody Profile request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profileService.create(request));
    }

    @GetMapping("/profiles/me")
    public ResponseEntity<List<Profile>> getAll() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(profileService.getAll());
    }

    @GetMapping("/profiles/{profileId}")
    public ResponseEntity<Profile> getById(
            @PathVariable Long profileId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(profileService.getById(profileId));
    }

    @PutMapping("profiles/{profileId}")
    public ResponseEntity<String> update(
            @PathVariable Long profileId,
            @RequestBody Profile request) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(profileService.update(profileId, request));
    }

    @DeleteMapping("profiles/{profileId}")
    public ResponseEntity<String> delete(
            @PathVariable Long profileId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(profileService.delete(profileId));
    }
    @GetMapping("/profiles/exists")
    public ResponseEntity<Boolean> exists(
            @RequestParam String email) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(profileService.existsByEmail(email));
    }
}