package com.rosewhat.cleanarchitecture.di.dagger

import android.content.Context
import com.rosewhat.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.rosewhat.cleanarchitecture.domain.usecases.SaveUserNameUseCase
import com.rosewhat.cleanarchitecture.presentation.MainViewModelFactory
import dagger.Module

@Module
class AppModdule(val context: Context) {

    fun provideContext(): Context {
        return context
    }

    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(getUserNameUseCase, saveUserNameUseCase)
    }
}