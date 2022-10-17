package com.rosewhat.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rosewhat.cleanarchitecture.data.repository.UserRepositoryImpl
import com.rosewhat.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.rosewhat.cleanarchitecture.data.storage.UserStorage
import com.rosewhat.cleanarchitecture.databinding.ActivityMainBinding
import com.rosewhat.cleanarchitecture.domain.model.SaveUserNameParam
import com.rosewhat.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.rosewhat.cleanarchitecture.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observe()
        binding.receiveButton.setOnClickListener {
            viewModel.load()

        }
        binding.sendButton.setOnClickListener {
            val text = binding.dataEditView.text.trim().toString()
            viewModel.save(text = text)
        }
    }
    private fun observe() {
        viewModel.result.observe(this) {
            binding.dataTextView.text = it
        }
    }
}