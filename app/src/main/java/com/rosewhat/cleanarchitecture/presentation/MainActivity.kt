package com.rosewhat.cleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rosewhat.cleanarchitecture.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel

// зависимости
@EntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //    private val viewModel by viewModel<MainViewModel>()
    private val viewModel: MainViewModel by viewModels()
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