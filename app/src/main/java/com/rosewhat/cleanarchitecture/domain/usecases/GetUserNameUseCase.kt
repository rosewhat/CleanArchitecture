package com.rosewhat.cleanarchitecture.domain.usecases

import com.rosewhat.cleanarchitecture.domain.model.UserName
import com.rosewhat.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun getName(): UserName {
        return userRepository.getName()
    }
}