package com.example.demo.service;

import com.example.demo.model.ProfileModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UserTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserModel userModel;

    @Autowired
    private ProfileModel profileModel;

    @Before
    public void setUp() {
        userService.addNewUser("Jean-Luc Picard", "123456", "04141125793", Long.valueOf(2));

    }

    @Test
    public void getByCpf()  {
        UserModel userModel = userService.getByCPF("04141125393");
        assertEquals(1, userModel.getIdUser());
        assertEquals("Daniela", userModel.getNameUser());
    }

    @Test
    public void testCPF() {
        assertEquals(userModel.getCpfUser().length(), hasSize(11));
        assertEquals(0,userService.getByCPF(userModel.getCpfUser()));
    }
}
