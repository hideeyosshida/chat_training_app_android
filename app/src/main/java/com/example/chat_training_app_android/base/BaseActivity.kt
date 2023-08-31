package com.example.chat_training_app_android.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelLazy
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BaseActivity<VM : BaseViewModel, VB: ViewBinding>(clazzVM: KClass<VM>) : AppCompatActivity() {
    protected lateinit var binding: VB
    protected val viewModelSelf by ViewModelLazy(
        clazzVM,
        {viewModelStore},
        {defaultViewModelProviderFactory}
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)
        initializeView(savedInstanceState)
    }

    abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    abstract fun initializeView(savedInstanceState: Bundle?)

    open fun onSubscribeObserver(){}

}