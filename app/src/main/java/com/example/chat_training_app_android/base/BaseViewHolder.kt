package com.example.chat_training_app_android.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class BaseViewHolder<T : ViewBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
