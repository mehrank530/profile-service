package com.careeragent.profile.service;

import com.careeragent.profile.entity.Profile;
import com.careeragent.profile.exception.CustomExceptions;
import com.careeragent.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public String create(Profile req) {

        if (profileRepository.existsByUserId(req.getUserId())) {
            throw new CustomExceptions(
                    "Profile already exists for userId: " + req.getUserId()
            );
        }

        if (profileRepository.existsByEmail(req.getEmail())) {
            throw new CustomExceptions(
                    "Email already exists: " + req.getEmail()
            );
        }

        Profile saved = profileRepository.save(req);
        if(null != saved){
           return "Profile created successfully";
        }else{
            return "unknow error";
        }
    }

}
