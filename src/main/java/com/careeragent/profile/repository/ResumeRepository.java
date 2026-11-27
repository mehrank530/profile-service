package com.careeragent.profile.repository;

import com.careeragent.profile.entity.Profile;
import com.careeragent.profile.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume,Long> {

    List<Resume> findByProfile(Profile profile);
}
