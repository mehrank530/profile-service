
package com.careeragent.profile.service;

import com.careeragent.profile.entity.Profile;
import com.careeragent.profile.exception.CustomExceptions;
import com.careeragent.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public String create(Profile req) {

        if (profileRepository.existsByEmail(req.getEmail())) {
            throw new CustomExceptions(
                    "Email already exists: " + req.getEmail()
            );
        }
        req.setCreatedDate(LocalDateTime.now());
        req.setUpdatedDate(LocalDateTime.now());

        profileRepository.save(req);
        return "Profile created successfully";
    }

    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    public Profile getById(Long profileId) {

        return profileRepository.findById(profileId)
                .orElseThrow(() -> new CustomExceptions(
                        "Profile not found with ID: " + profileId
                ));
    }

    public String update(Long profileId, Profile req) {

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new CustomExceptions(
                        "Profile not found with ID: " + profileId
                ));
        if (!profile.getEmail().equals(req.getEmail())
                && profileRepository.existsByEmail(req.getEmail())) {

            throw new CustomExceptions(
                    "Email already exists: " + req.getEmail()
            );
        }
        profile.setUserId(req.getUserId());
        profile.setFirstName(req.getFirstName());
        profile.setLastName(req.getLastName());
        profile.setProfessionalHeadline(req.getProfessionalHeadline());
        profile.setEmail(req.getEmail());
        profile.setPhoneNumber(req.getPhoneNumber());
        profile.setCountry(req.getCountry());
        profile.setCity(req.getCity());
        profile.setProfessionalSummary(req.getProfessionalSummary());
        profile.setYearsOfExperience(req.getYearsOfExperience());
        profile.setCurrentJobTitle(req.getCurrentJobTitle());
        profile.setCurrentCompany(req.getCurrentCompany());
        profile.setProfilePictureUrl(req.getProfilePictureUrl());
        profile.setLinkedInUrl(req.getLinkedInUrl());
        profile.setGitHubUrl(req.getGitHubUrl());
        profile.setPortfolioUrl(req.getPortfolioUrl());

        profile.setUpdatedDate(LocalDateTime.now());

        profileRepository.save(profile);
        return "Profile updated successfully";
    }

    public String delete(Long profileId) {

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new CustomExceptions(
                        "Profile not found with ID: " + profileId
                ));
        profileRepository.delete(profile);
        return "Profile deleted successfully";
    }

       public boolean existsByEmail(String email) {
        return profileRepository.existsByEmail(email);
    }
}
