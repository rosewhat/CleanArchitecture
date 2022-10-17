package com.rosewhat.cleanarchitecture.di

import com.rosewhat.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.rosewhat.cleanarchitecture.domain.usecases.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }
    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}