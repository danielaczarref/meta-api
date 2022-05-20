package com.example.demo.service;

import com.example.demo.model.ProfileModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileService profileService;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getByIdUser(Long idUser) {
        Optional<UserModel> result = userRepository.findById(idUser);
        if (result.isPresent()) {
            return result.get();
        }
        else {
            return null;
        }
    }

    public String addNewUser(String nameUser, String passwordUser, String cpfUser, Long idProfile) {
        Optional<ProfileModel> resultProfile = Optional.ofNullable(profileService.getById(idProfile));
        ProfileModel profileModel;
        if (resultProfile.isPresent()) {
            profileModel = resultProfile.get();
        } else {
            return "id do perfil nao encontrado";
        }

        UserModel newUser = new UserModel();
        newUser.setNameUser(nameUser);
        newUser.setPasswordUser(passwordUser);
        newUser.setCpfUser(cpfUser);
        newUser.setProfile(profileModel);

        userRepository.save(newUser);
        return "Success";
    }

    public UserModel getByCPF(String cpf) {
        Optional<UserModel> result = Optional.ofNullable(userRepository.findByCpfUser(cpf));
        if (result.isPresent()) {
            return result.get();
        }
        else {
            return null;
        }
    }

    public List<UserModel> getAllByProfile(long idProfile) {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setIdProfile(idProfile);
        return userRepository.findByProfile(profileModel);
    }
}
