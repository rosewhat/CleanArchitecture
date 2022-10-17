package com.rosewhat.cleanarchitecture.domain.usecases

import com.rosewhat.cleanarchitecture.domain.model.UserName

class GetUserNameUseCase {
    fun execute(): UserName {
        return UserName(firstName = "First", lastName = "Last")
    }
}