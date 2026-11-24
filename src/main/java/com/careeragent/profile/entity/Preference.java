package com.careeragent.profile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preferenceId;

    @Column(length = 255)
    private String preferredJobTitles;

    @Column(length = 255)
    private String preferredIndustries;

    @Column(length = 255)
    private String preferredEmploymentTypes;

    @Column(length = 255)
    private String preferredWorkLocations;

    @Column(length = 50)
    private String remoteWorkPreference;

    @Column
    private Boolean willingToRelocate;

    @Column(length = 255)
    private String preferredCountries;

    @Column(precision = 15, scale = 2)
    private BigDecimal minimumExpectedSalary;

    @Column(precision = 15, scale = 2)
    private BigDecimal maximumExpectedSalary;

    @Column(length = 10)
    private String salaryCurrency;

    @Column(length = 50)
    private String preferredSalaryPeriod;

    @Column(precision = 15, scale = 2)
    private BigDecimal minimumFreelanceProjectBudget;

    @Column(length = 50)
    private String preferredJobExperienceLevel;

    @Column(length = 100)
    private String noticePeriod;

    @Column(length = 100)
    private String availabilityStatus;


}
