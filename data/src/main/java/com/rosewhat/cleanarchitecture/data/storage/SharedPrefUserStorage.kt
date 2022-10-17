package com.rosewhat.cleanarchitecture.data.storage

import android.content.Context
import com.rosewhat.cleanarchitecture.domain.model.SaveUserNameParam
import com.rosewhat.cleanarchitecture.domain.model.UserName

private const val SHARED_PREFERENCES = "shared_pref"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "secondName"
private const val DEFAULT_NAME = "Default last name"
private const val DEFAULT_LAST_NAME = "Default last name"
class SharedPrefUserStorage(context: Context): UserStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    override fun saveName(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun getName(): User {
        val fistName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_LAST_NAME
        return User(firstName = fistName, lastName = lastName)
    }
}