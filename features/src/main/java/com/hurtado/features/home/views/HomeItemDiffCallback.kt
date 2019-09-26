package com.hurtado.features.home.views

import androidx.recyclerview.widget.DiffUtil
import com.hurtado.data.entities.Item

class HomeItemDiffCallback(private val oldList: List<Item>,
                           private val newList: List<Item>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].confidence == newList[newItemPosition].confidence
    }
}