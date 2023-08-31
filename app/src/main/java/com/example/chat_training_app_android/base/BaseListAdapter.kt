package com.example.chat_training_app_android.base

import android.view.View
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chat_training_app_android.extention.ItemClickListener

abstract class BaseListAdapter<T, VH : RecyclerView.ViewHolder>(
    areItemsTheSameCallback: (old: T, new: T) -> Boolean,
    areContentsTheSameCallback: (old: T, new: T) -> Boolean
) : ListAdapter<T, VH>(GenericDiffUtil(areItemsTheSameCallback, areContentsTheSameCallback)) {

    var forItemClickListener: ItemClickListener<T>? = null
    var forItemLongClickListener: ItemClickListener<T>? = null

    open fun bindFirstTime(itemView: View, holder: VH, isDelayClick: Boolean = false) {

        itemView.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION)
                forItemClickListener?.forItem(
                    holder.adapterPosition,
                    getItem(holder.adapterPosition),
                    it
                )
        }

        itemView.setOnLongClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION)
                forItemLongClickListener?.forItem(
                    holder.adapterPosition,
                    getItem(holder.adapterPosition),
                    it
                )
            return@setOnLongClickListener true
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item: T = getItem(position)
        bindItems(item, holder, position, itemCount)
    }

    abstract fun bindItems(item: T, holder: VH, position: Int, itemCount: Int)
}