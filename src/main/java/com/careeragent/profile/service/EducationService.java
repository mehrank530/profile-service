package com.careeragent.profile.service;

import com.careeragent.profile.entity.Education;
import com.careeragent.profile.exception.CustomExceptions;
import com.careeragent.profile.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public String create(Education req){
        educationRepository.save(req);
        return "Education information created successfully";
    }

    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    public Education getById(Long educationId) {

        return educationRepository.findById(educationId)
                .orElseThrow(() -> new CustomExceptions(
                        "Education not found with ID: " + educationId
                ));
    }

    public String update(Long educationId, Education req) {

        Education education = educationRepository.findById(educationId)
                .orElseThrow(() -> new CustomExceptions(
                        "Education not found with ID: " + educationId
                ));

        education.setInstitutionName(req.getInstitutionName());
        education.setDegree(req.getDegree());
        education.setFieldOfStudy(req.getFieldOfStudy());
        education.setStartDate(req.getStartDate());
        education.setEndDate(req.getEndDate());
        education.setCurrentlyStudying(req.getCurrentlyStudying());
        education.setGrade(req.getGrade());
        education.setDescription(req.getDescription());

        educationRepository.save(education);

        return "Education updated successfully";
    }

    public String delete(Long educationId) {

        Education education = educationRepository.findById(educationId)
                .orElseThrow(() -> new CustomExceptions(
                        "Education not found with ID: " + educationId
                ));
        educationRepository.delete(education);
        return "Education deleted successfully";

}


}
