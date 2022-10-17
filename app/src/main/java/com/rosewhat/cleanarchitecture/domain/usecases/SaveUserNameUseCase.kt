package com.rosewhat.cleanarchitecture.domain.usecases

import com.rosewhat.cleanarchitecture.domain.model.SaveUserNameParam

class SaveUserNameUseCase {
    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }
}