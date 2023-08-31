package com.example.chat_training_app_android.viewmodel

import android.content.Context
import com.example.chat_training_app_android.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext val context: Context
) : BaseViewModel(){
}