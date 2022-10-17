package com.rosewhat.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rosewhat.cleanarchitecture.domain.model.SaveUserNameParam
import com.rosewhat.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.rosewhat.cleanarchitecture.domain.usecases.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result


    fun save(text: String) {
        val saveUserNameParam = SaveUserNameParam(name = text)
        val textView = saveUserNameUseCase.saveName(param = saveUserNameParam)
        _result.value = textView.toString()
    }

    fun load() {
        val userName = getUserNameUseCase.getName()
        _result.value = "${userName.firstName} ${userName.lastName}"
    }
}