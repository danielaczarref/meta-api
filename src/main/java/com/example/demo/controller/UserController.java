package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping(value="/cpfUser={cpfUser}")
    public ResponseEntity<UserModel> getUserByCPF(@PathVariable String cpfUser) {
        return ResponseEntity.ok().body(userService.getByCPF(cpfUser));
    }

    @GetMapping(value="/idProfile={idProfile}")
    public ResponseEntity<List<UserModel>> getAllUserByProfile(@PathVariable Long idProfile) {
        return ResponseEntity.ok().body(userService.getAllByProfile(idProfile));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addUser(@RequestParam(name="nome") String nameUser,
                                          @RequestParam(name="senha") String passwordUser,
                                          @RequestParam(name="cpf") String cpfUser,
                                          @RequestParam(name="idProfile") Long idProfile) {
        String response = userService.addNewUser(nameUser, passwordUser, cpfUser, idProfile);
        if (response.equals("Success")) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body(response);
    }
}
