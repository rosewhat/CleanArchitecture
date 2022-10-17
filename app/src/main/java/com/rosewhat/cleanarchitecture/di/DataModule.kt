package com.rosewhat.cleanarchitecture.di

import com.rosewhat.cleanarchitecture.data.repository.UserRepositoryImpl
import com.rosewhat.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.rosewhat.cleanarchitecture.data.storage.UserStorage
import com.rosewhat.cleanarchitecture.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        //ищет context
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        //ищет context
        UserRepositoryImpl(userStorage = get())
    }


}