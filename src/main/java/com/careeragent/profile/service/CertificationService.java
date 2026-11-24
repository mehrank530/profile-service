package com.careeragent.profile.service;

import com.careeragent.profile.entity.Certification;
import com.careeragent.profile.exception.CustomExceptions;
import com.careeragent.profile.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    public String create(Certification req) {
        certificationRepository.save(req);
        return "Certification information created successfully";

    }
    public List<Certification> getAllCertification(){
        return certificationRepository.findAll();
    }

    public Certification getBYId(Long certificationId){

        return certificationRepository.findById(certificationId)
                .orElseThrow(() -> new CustomExceptions(
                        "Certification not found with ID: " + certificationId
                ));
    }

    public String update(Long certificationId, Certification req) {

        Certification certification = certificationRepository.findById(certificationId)
                .orElseThrow(() -> new CustomExceptions(
                        "Experience not found with ID: " + certificationId
                ));

        certification.setCertificationName(req.getCertificationName());
        certification.setIssuingOrganization(req.getIssuingOrganization());
        certification.setIssueDate(req.getIssueDate());
        certification.setExpirationDate(req.getExpirationDate());
        certification.setCredentialId(req.getCredentialId());
        certification.setCredentialUrl(req.getCredentialUrl());

        certificationRepository.save(certification);

        return "Certification updated successfully";
    }

    public String delete(Long certificationId){

        Certification certification = certificationRepository.findById(certificationId)
                .orElseThrow(() -> new CustomExceptions(
                        "Certification not found with ID: " + certificationId
                ));
        certificationRepository.delete(certification);
        return "Certification deleted successfully";


    }

}
