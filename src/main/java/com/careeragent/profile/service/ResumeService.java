package com.careeragent.profile.service;

import com.careeragent.profile.entity.Profile;
import com.careeragent.profile.entity.Resume;
import com.careeragent.profile.exception.CustomExceptions;
import com.careeragent.profile.repository.ProfileRepository;
import com.careeragent.profile.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public String uploadResume(Long profileId, MultipartFile file) {

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new CustomExceptions("Profile not found"));

        if (file == null || file.isEmpty()) {
            throw new CustomExceptions("Please select a resume file");
        }

        Resume resume = new Resume();

        resume.setProfile(profile);
        resume.setOriginalFilename(file.getOriginalFilename());
        resume.setFileType(file.getContentType());
        resume.setFileSize(file.getSize());

        resume.setStorageReference(
                "resumes/profile-" + profileId + "/" + file.getOriginalFilename()
        );

        resume.setPrimaryResume(false);

        resume.setUploadedDate(LocalDateTime.now());
        resume.setLastUpdatedDate(LocalDateTime.now());

        resumeRepository.save(resume);

        return "Resume uploaded successfully";
    }

    public List<Resume> getAllResume(Long profileId) {

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new CustomExceptions(
                        "Profile not found with ID: " + profileId
                ));

        return resumeRepository.findByProfile(profile);
    }

    public Resume getByIdResume(Long resumeId) {

        return resumeRepository.findById(resumeId)
                .orElseThrow(() -> new CustomExceptions(
                        "Resume not found with ResumeId: " + resumeId
                ));
    }

    public String update(Long resumeId, Resume req) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new CustomExceptions(
                        "Resume not found with ResumeId: " + resumeId
                ));

        resume.setOriginalFilename(req.getOriginalFilename());
        resume.setFileType(req.getFileType());
        resume.setFileSize(req.getFileSize());
        resume.setStorageReference(req.getStorageReference());
        resume.setPrimaryResume(req.getPrimaryResume());

        resume.setLastUpdatedDate(LocalDateTime.now());

        resumeRepository.save(resume);

        return "Resume updated successfully";
    }

    public String delete(Long resumeId) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new CustomExceptions(
                        "Resume not found with ResumeId: " + resumeId
                ));

        resumeRepository.delete(resume);

        return "Resume deleted successfully";
    }

    public String setPrimaryResume(Long resumeId) {

        Resume selectedResume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new CustomExceptions(
                        "Resume not found with ID: " + resumeId
                ));

        Profile profile = selectedResume.getProfile();

        List<Resume> resumes = resumeRepository.findByProfile(profile);

        for (Resume resume : resumes) {

            if (resume.getResumeId().equals(resumeId)) {
                resume.setPrimaryResume(true);
            } else {
                resume.setPrimaryResume(false);
            }
        }

        resumeRepository.saveAll(resumes);

        return "Primary resume set successfully";
    }
}