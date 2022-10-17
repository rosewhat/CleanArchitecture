package com.rosewhat.cleanarchitecture.data.storage

import com.rosewhat.cleanarchitecture.domain.model.SaveUserNameParam
import com.rosewhat.cleanarchitecture.domain.model.UserName

interface UserStorage {

    fun saveName(param: User): Boolean
    fun getName(): User
}