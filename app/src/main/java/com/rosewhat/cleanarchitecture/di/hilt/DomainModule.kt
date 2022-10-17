package com.rosewhat.cleanarchitecture.di.hilt

import com.rosewhat.cleanarchitecture.domain.repository.UserRepository
import com.rosewhat.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.rosewhat.cleanarchitecture.domain.usecases.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    @Singleton
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository)
    }
}