package com.careeragent.profile.controller;

import com.careeragent.profile.entity.Profile;
import com.careeragent.profile.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

    @Autowired
    private  ProfileService profileService;

    @PostMapping("/profiles")
    public ResponseEntity<String> create(
            @Valid @RequestBody Profile request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profileService.create(request));
    }
}



