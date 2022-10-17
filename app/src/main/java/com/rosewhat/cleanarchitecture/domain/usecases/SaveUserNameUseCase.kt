package com.rosewhat.cleanarchitecture.domain.usecases

import com.rosewhat.cleanarchitecture.domain.model.SaveUserNameParam
import com.rosewhat.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun saveName(param: SaveUserNameParam): Boolean {
        return userRepository.saveName(param = param)
    }
}