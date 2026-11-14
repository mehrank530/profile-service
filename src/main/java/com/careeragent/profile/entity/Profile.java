package com.careeragent.profile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(nullable = true)
    private Long userId;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 255)
    private String professionalHeadline;

    @Column(name = "email")
    private String email;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String professionalSummary;

    @Column(nullable = false)
    private Integer yearsOfExperience;

    @Column(nullable = false, length = 150)
    private String currentJobTitle;

    @Column(length = 150)
    private String currentCompany;

    @Column(length = 500)
    private String profilePictureUrl;

    @Column(length = 500)
    private String linkedInUrl;

    @Column(length = 500)
    private String gitHubUrl;

    @Column(length = 500)
    private String portfolioUrl;

    @Column(name = "created_date", updatable = false)
    LocalDateTime CreatedDate;

    @Column(name = "updated_date", updatable = false)
    LocalDateTime updatedDate;

}
