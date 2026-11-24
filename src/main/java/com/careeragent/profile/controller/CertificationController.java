package com.careeragent.profile.controller;

import com.careeragent.profile.entity.Certification;
import com.careeragent.profile.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @PostMapping("/me/certifications")
    public ResponseEntity<String> create(
            @RequestBody Certification certification) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(certificationService.create(certification));
    }

    @GetMapping("/me/certifications")
    public ResponseEntity<List<Certification>> getAllCertification() {
        return ResponseEntity.ok(
                certificationService.getAllCertification());
    }

    @GetMapping("/me/certifications/{certificationId}")
    public ResponseEntity<Certification> getByCertification(
            @PathVariable Long certificationId) {
        return ResponseEntity.ok(
                certificationService.getBYId(certificationId));
    }

    @PutMapping("/me/certifications/{certificationId}")
    public ResponseEntity<String> update(
            @PathVariable Long certificationId,
            @RequestBody Certification certification) {

        return ResponseEntity.ok(
                certificationService.update(certificationId, certification)
        );
    }

    @DeleteMapping("/me/certifications/{certificationId}")
    public ResponseEntity<String> delete(
            @PathVariable Long certificationId) {

        return ResponseEntity.ok(
                certificationService.delete(certificationId));
    }
}
