package com.rosewhat.cleanarchitecture.data.repository

import android.content.Context
import com.rosewhat.cleanarchitecture.domain.model.SaveUserNameParam
import com.rosewhat.cleanarchitecture.domain.model.UserName
import com.rosewhat.cleanarchitecture.domain.repository.UserRepository

private const val SHARED_PREFERENCES = "shared_pref"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "secondName"
private const val DEFAULT_NAME = "Default last name"
private const val DEFAULT_LAST_NAME = "Default last name"


class UserRepositoryImpl(context: Context) : UserRepository {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun getName(): UserName {
        val fistName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_LAST_NAME
        return UserName(firstName = fistName, lastName = lastName)
    }

    override fun saveName(param: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, param.name).apply()
        return true
    }
}