package com.careeragent.profile.controller;

import com.careeragent.profile.entity.Preference;
import com.careeragent.profile.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @PostMapping("/me/preferences")
    public ResponseEntity<String> create(
            @RequestBody Preference preference) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(preferenceService.create(preference));
    }

    @GetMapping("/me/preferences")
    public ResponseEntity<List<Preference>> getAllPreference(){
        return ResponseEntity.ok(
                preferenceService.getAllPreference());
    }

    @PutMapping("/me/preferences/{preferenceId}")
    public ResponseEntity<String> update(
            @PathVariable Long preferenceId,
            @RequestBody Preference preference) {

        return ResponseEntity.ok(
                preferenceService.update(preferenceId, preference)
        );
    }

    @DeleteMapping("/me/preferences/{preferenceId}")
    public ResponseEntity<String> delete(
            @PathVariable Long preferenceId) {

        return ResponseEntity.ok(
                preferenceService.delete(preferenceId));
    }

}
