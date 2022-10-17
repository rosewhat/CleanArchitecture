package com.rosewhat.cleanarchitecture.data.repository

import com.rosewhat.cleanarchitecture.data.storage.User
import com.rosewhat.cleanarchitecture.data.storage.UserStorage
import com.rosewhat.cleanarchitecture.domain.model.SaveUserNameParam
import com.rosewhat.cleanarchitecture.domain.model.UserName
import com.rosewhat.cleanarchitecture.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun getName(): UserName {

        val user = userStorage.getName()
        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }

    override fun saveName(param: SaveUserNameParam): Boolean {
        val name = User(firstName = param.name, lastName = "")
        return userStorage.saveName(param = name)
    }
}