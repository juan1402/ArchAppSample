package com.hurtado.features.home.views

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hurtado.common.extensions.inflate
import com.hurtado.data.entities.Item
import com.hurtado.features.R
import com.hurtado.features.home.HomeViewModel

class HomeAdapter(private val viewModel: HomeViewModel) : RecyclerView.Adapter<HomeViewHolder>() {

    private val users: MutableList<Item> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(parent.inflate(R.layout.list_item))

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) =
        holder.bindTo(users[position], viewModel)

    // ---

    fun updateData(items: List<Item>) {
        val diffCallback = HomeItemDiffCallback(users, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        users.clear()
        users.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }
}