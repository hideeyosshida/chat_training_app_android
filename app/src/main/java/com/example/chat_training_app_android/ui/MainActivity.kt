package com.example.chat_training_app_android.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.example.chat_training_app_android.base.BaseActivity
import com.example.chat_training_app_android.databinding.MainActivityBinding
import com.example.chat_training_app_android.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, MainActivityBinding>(MainViewModel::class){
    override fun inflateViewBinding(inflater: LayoutInflater): MainActivityBinding {
        return MainActivityBinding.inflate(inflater)
    }

    override fun initializeView(savedInstanceState: Bundle?) {
        println()

    }
}