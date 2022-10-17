package com.rosewhat.cleanarchitecture.di.dagger

import android.content.Context
import com.rosewhat.cleanarchitecture.data.repository.UserRepositoryImpl
import com.rosewhat.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.rosewhat.cleanarchitecture.data.storage.UserStorage
import com.rosewhat.cleanarchitecture.domain.repository.UserRepository
import dagger.Module

@Module
class DataModdule {

    fun provideUserRepository(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

}