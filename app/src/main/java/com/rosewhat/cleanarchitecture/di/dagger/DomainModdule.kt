package com.rosewhat.cleanarchitecture.di.dagger

import com.rosewhat.cleanarchitecture.data.repository.UserRepositoryImpl
import com.rosewhat.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.rosewhat.cleanarchitecture.domain.repository.UserRepository
import com.rosewhat.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.rosewhat.cleanarchitecture.domain.usecases.SaveUserNameUseCase
import dagger.Module

@Module
class DomainModdule {

    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }

    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository)
    }
}

