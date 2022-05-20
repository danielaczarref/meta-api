package com.example.demo.controller;

import com.example.demo.model.ProfileModel;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<ProfileModel>> getAllProfiles() {
        return ResponseEntity.ok().body(profileService.getAllProfiles());
    }

    @GetMapping(value = "/{idProfile}")
    public ResponseEntity<ProfileModel> getByIdProfile(@PathVariable long idProfile) {
        return ResponseEntity.ok().body(profileService.getById(idProfile));
    }

    @GetMapping(value = "/idUser={idUser}")
    public ResponseEntity<ProfileModel> getProfileByUser(@PathVariable long idUser) {
        return ResponseEntity.ok().body(profileService.getByUser(idUser));
    }

    @PostMapping
    public ResponseEntity<String> addNewProfile(@RequestParam(name="descricao") String labelProfile) {
        String response = profileService.addNewProfile(labelProfile);
        if (response.equals("Success")) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body(response);
    }
}
