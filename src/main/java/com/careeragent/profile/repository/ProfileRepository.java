package com.careeragent.profile.repository;

import com.careeragent.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    boolean existsByEmail(String email);
}
