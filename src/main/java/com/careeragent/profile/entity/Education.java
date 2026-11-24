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
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;

    @Column(name = "institution_name", nullable = false, length = 200)
    private String institutionName;

    @Column(nullable = false, length = 150)
    private String degree;

    @Column(name = "field_of_study", nullable = false, length = 150)
    private String fieldOfStudy;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "currently_studying", nullable = false)
    private Boolean currentlyStudying = false;

    @Column(length = 50)
    private String grade;

    @Column(columnDefinition = "TEXT")
    private String description;

}
