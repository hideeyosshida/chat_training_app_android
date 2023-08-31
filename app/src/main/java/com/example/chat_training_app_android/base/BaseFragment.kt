package com.example.chat_training_app_android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(clazzVM: KClass<VM>) : Fragment() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!
    protected val viewModelSelf by createViewModelLazy(clazzVM, { viewModelStore })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView(view, savedInstanceState)
    }

    abstract fun initializeView(view: View, savedInstanceState: Bundle?)

    abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    open fun onSubscribeObserver(){
    }
}