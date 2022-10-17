package com.rosewhat.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rosewhat.cleanarchitecture.data.repository.UserRepositoryImpl
import com.rosewhat.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.rosewhat.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.rosewhat.cleanarchitecture.domain.usecases.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepositoryImpl by lazy {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }

    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(userRepositoryImpl)
    }

    private val saveUserNameUseCase by lazy {
        SaveUserNameUseCase(userRepositoryImpl)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}