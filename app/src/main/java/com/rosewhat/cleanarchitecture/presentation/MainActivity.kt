package com.rosewhat.cleanarchitecture.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rosewhat.cleanarchitecture.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<MainViewModel>()
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