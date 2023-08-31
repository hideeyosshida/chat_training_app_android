package com.example.chat_training_app_android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ChatApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}