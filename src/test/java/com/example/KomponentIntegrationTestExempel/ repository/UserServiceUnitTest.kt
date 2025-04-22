package com.example.KomponentIntegrationTestExempel.service

import com.example.KomponentIntegrationTestExempel.model.User
import com.example.KomponentIntegrationTestExempel.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class UserServiceUnitTest {
    @Mock
    private val userRepository: UserRepository? = null

    @InjectMocks
    private val userService: UserService? = null

    @Test
    fun testGetUserByIdReturnsUser() {
        // Arrange
        val user = User(1L, "Eliana", "eliana@mail.com")
        Mockito.`when`(userRepository!!.findById(1L)).thenReturn(Optional.of(user))

        // Act
        val result = userService!!.getUserById(1L).orElse(null)

        // Assert
        Assertions.assertEquals("Eliana", result!!.name)
        Mockito.verify(userRepository).findById(1L)
    }
}