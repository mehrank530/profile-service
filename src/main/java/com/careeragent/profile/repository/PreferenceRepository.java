package com.careeragent.profile.repository;

import com.careeragent.profile.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PreferenceRepository  extends JpaRepository<Preference,Long> {

}
