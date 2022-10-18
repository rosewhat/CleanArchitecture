package com.rosewhat.cleanarchitecture.domain.usecases

import com.rosewhat.cleanarchitecture.domain.model.UserName
import com.rosewhat.cleanarchitecture.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


class GetUserNameUseCaseTest {

    val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as it repository`() {

        val testUserName = UserName(firstName = "test firstName", lastName = "test last name")
        // когда вызов этого теста будет -> вернет значения выше
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val actual = GetUserNameUseCase(userRepository = userRepository).getName()

        val expected = UserName(firstName = "test firstName", lastName = "test last name")

        Assertions.assertEquals(expected, actual)
    }

}