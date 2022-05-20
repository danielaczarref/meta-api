package com.example.demo.service;

import com.example.demo.model.ProfileModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public ProfileModel getById(Long idProfile) {
        Optional<ProfileModel> result = profileRepository.findById(idProfile);
        if (result.isPresent()) {
            return result.get();
        }
        else {
            return null;
        }
    }

    public String addNewProfile(String labelProfile) {
        ProfileModel newProfile = new ProfileModel();
        newProfile.setLabelProfile(labelProfile);

        profileRepository.save(newProfile);
        return "Success";
    }

    public List<ProfileModel> getAllProfiles() {
        return profileRepository.findAll();
    }

    public ProfileModel getByUser(Long idUser) {
        UserModel userModel = new UserModel();
        userModel.setIdUser(idUser);
        return userModel.getProfile();
    }
}
