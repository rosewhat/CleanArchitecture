package com.rosewhat.cleanarchitecture.di.hilt

import android.content.Context
import com.rosewhat.cleanarchitecture.data.repository.UserRepositoryImpl
import com.rosewhat.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.rosewhat.cleanarchitecture.data.storage.UserStorage
import com.rosewhat.cleanarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideUserRepository(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Singleton
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}