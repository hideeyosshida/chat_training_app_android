package com.example.chat_training_app_android.extention

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface ItemClickListener<T> {
    fun forItem(position: Int, item: T, view: View)
}

inline fun <T> itemClickListenerDSL(crossinline callback: (position: Int, item: T, view: View) -> Unit = { _, _, _ -> }) =
    object : ItemClickListener<T> {
        override fun forItem(position: Int, item: T, view: View) {
            callback(position, item, view)
        }
    }
val RecyclerView.ViewHolder.context: Context
    get() = this.itemView.context