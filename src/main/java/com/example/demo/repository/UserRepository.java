package com.example.demo.repository;

import com.example.demo.model.ProfileModel;
import com.example.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByProfile(ProfileModel profile);
    UserModel findByCpfUser(String cpfUser);
    @Override
    List<UserModel> findAll();
}
