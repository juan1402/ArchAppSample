package com.hurtado.features.home.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.hurtado.data.entities.Item
import com.hurtado.data.repository.ItemRepository
import com.hurtado.data.repository.utils.Resource

class GetItemUseCase(private val repository: ItemRepository) {

    suspend operator fun invoke(forceRefresh: Boolean = false, page: String): LiveData<Resource<List<Item>>> {
        return Transformations.map(repository.getItemPage(forceRefresh, page)) {
            it // Place here your specific logic actions
        }
    }
}