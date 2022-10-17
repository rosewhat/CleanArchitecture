package com.rosewhat.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rosewhat.cleanarchitecture.data.repository.UserRepositoryImpl
import com.rosewhat.cleanarchitecture.databinding.ActivityMainBinding
import com.rosewhat.cleanarchitecture.domain.model.SaveUserNameParam
import com.rosewhat.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.rosewhat.cleanarchitecture.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val userRepositoryImpl by lazy {
        UserRepositoryImpl(context = applicationContext)
    }

    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(userRepositoryImpl)
    }

    private val saveUserNameUseCase by lazy {
        SaveUserNameUseCase(userRepositoryImpl)
    }
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.receiveButton.setOnClickListener {

            val userName = getUserNameUseCase.getName()
            binding.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
        binding.sendButton.setOnClickListener {
            val text = binding.dataEditView.text.trim().toString()
            val saveUserNameParam = SaveUserNameParam(name = text)
            val textView = saveUserNameUseCase.saveName(param = saveUserNameParam)
            binding.dataTextView.text = textView.toString()
        }
    }
}