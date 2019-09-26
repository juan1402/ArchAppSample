package com.hurtado.features.home.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hurtado.data.entities.Item
import com.hurtado.features.databinding.ListItemBinding
import com.hurtado.features.home.HomeViewModel

class HomeViewHolder(parent: View): RecyclerView.ViewHolder(parent) {

    private val binding = ListItemBinding.bind(parent)

    fun bindTo(item: Item, viewModel: HomeViewModel) {
        binding.viewModel = viewModel
        binding.item = item
    }
}