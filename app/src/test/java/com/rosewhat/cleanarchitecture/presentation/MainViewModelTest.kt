package com.rosewhat.cleanarchitecture.presentation


import com.rosewhat.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.rosewhat.cleanarchitecture.domain.usecases.SaveUserNameUseCase
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.mockito.kotlin.mock
import org.mockito.kotlin.reset

class MainViewModelTest {

    private val getUserNameUseCase = mock<GetUserNameUseCase>()
    private val saveUserNameUseCase = mock<SaveUserNameUseCase>()

    lateinit var viewModel: MainViewModel


    @AfterEach
    fun afterEach() {
        reset(getUserNameUseCase)
        reset(saveUserNameUseCase)
    }

    @BeforeEach
    fun beforeEach() {
        viewModel = MainViewModel(
            getUserNameUseCase,
            saveUserNameUseCase
        )
    }

    @Test
    fun `should save username and return true`() {

    }

    @Test
    fun `should save username and return false`() {

    }

    @Test
    fun `should load username`() {

    }
}