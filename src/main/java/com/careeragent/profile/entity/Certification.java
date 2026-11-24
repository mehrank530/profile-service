package com.careeragent.profile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificationId;

    @Column(name = "certification_name", nullable = false)
    private String certificationName;

    @Column(name = "issuing_organization", nullable = false)
    private String issuingOrganization;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "credential_id")
    private String credentialId;

    @Column(name = "credential_url")
    private String credentialUrl;
}