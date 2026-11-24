package com.careeragent.profile.service;

import com.careeragent.profile.entity.Preference;
import com.careeragent.profile.exception.CustomExceptions;
import com.careeragent.profile.repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    public String create(Preference req) {
        preferenceRepository.save(req);
        return "Preference information created successfully";
    }

    public List<Preference> getAllPreference() {
        return preferenceRepository.findAll();
    }

    public String update(Long preferenceId, Preference req) {

        Preference preference = preferenceRepository.findById(preferenceId)
                .orElseThrow(() -> new CustomExceptions(
                        "Preference not found with ID: " + preferenceId
                ));

        preference.setPreferredJobTitles(req.getPreferredJobTitles());
        preference.setPreferredIndustries(req.getPreferredIndustries());
        preference.setPreferredEmploymentTypes(req.getPreferredEmploymentTypes());
        preference.setPreferredWorkLocations(req.getPreferredWorkLocations());
        preference.setRemoteWorkPreference(req.getRemoteWorkPreference());
        preference.setWillingToRelocate(req.getWillingToRelocate());
        preference.setPreferredCountries(req.getPreferredCountries());
        preference.setMinimumExpectedSalary(req.getMinimumExpectedSalary());
        preference.setMaximumExpectedSalary(req.getMaximumExpectedSalary());
        preference.setSalaryCurrency(req.getSalaryCurrency());
        preference.setMaximumExpectedSalary(req.getMaximumExpectedSalary());
        preference.setPreferredSalaryPeriod(req.getPreferredSalaryPeriod());
        preference.setMinimumFreelanceProjectBudget(req.getMinimumFreelanceProjectBudget());
        preference.setPreferredJobExperienceLevel(req.getPreferredJobExperienceLevel());
        preference.setNoticePeriod(req.getNoticePeriod());
        preference.setAvailabilityStatus(req.getAvailabilityStatus());

        preferenceRepository.save(preference);

        return "Preference updated successfully";
    }

    public String delete(Long preferenceId) {

        Preference preference = preferenceRepository.findById(preferenceId)
                .orElseThrow(() -> new CustomExceptions(
                        "Preference not found with ID: " + preferenceId
                ));
        preferenceRepository.delete(preference);
        return "Preference deleted successfully";
    }


}
