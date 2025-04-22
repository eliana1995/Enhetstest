package com.example.KomponentIntegrationTestExempel.service;

import com.example.KomponentIntegrationTestExempel.model.User;
import com.example.KomponentIntegrationTestExempel.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceCompononentTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setup() {
        userRepository.deleteAll();
    }

    @Test
    public void testCreateAndFetchUser() {
        // Arrange
        User user = new User(null, "Eliana", "eliana@mail.com");

        // Act
        User savedUser = userService.createUser(user);
        User fetchedUser = userService.getUserById(savedUser.getId()).orElse(null);

        // Assert
        assertNotNull(fetchedUser);
        assertEquals("Eliana", fetchedUser.getName());
        assertEquals("eliana@mail.com", fetchedUser.getEmail());
    }
}
