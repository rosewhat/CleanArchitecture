package com.rosewhat.cleanarchitecture.domain.repository

import com.rosewhat.cleanarchitecture.domain.model.SaveUserNameParam
import com.rosewhat.cleanarchitecture.domain.model.UserName

interface UserRepository {
    fun getName(): UserName
    fun saveName(param: SaveUserNameParam): Boolean
}