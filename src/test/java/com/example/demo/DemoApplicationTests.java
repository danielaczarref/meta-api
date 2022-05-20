package com.example.demo;

import com.example.demo.model.ProfileModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProfileService;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	public void createProfile() {
		ProfileModel profileModel = new ProfileModel();
		profileModel.setLabelProfile("Administrador");
		profileRepository.save(profileModel);
		assertNotNull(profileRepository.findById(Long.valueOf(1)).get());
	}

}
