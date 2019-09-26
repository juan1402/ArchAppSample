package com.hurtado.data.repository

import androidx.lifecycle.LiveData
import com.hurtado.data.local.dao.ItemDao
import com.hurtado.data.entities.Item
import com.hurtado.data.remote.ItemDataSource
import com.hurtado.data.repository.utils.NetworkBoundResource
import com.hurtado.data.repository.utils.Resource
import kotlinx.coroutines.Deferred

interface ItemRepository {
    suspend fun getItemPage(
        forceRefresh: Boolean = false,
        page: String?
    ): LiveData<Resource<List<Item>>>
}

class ItemRepositoryImpl(
    private val dataSource: ItemDataSource,
    private val dao: ItemDao
) : ItemRepository {

    /**
     * Suspended function that will get a list of top [User]
     * whether in cache (SQLite) or via network (API).
     * [NetworkBoundResource] is responsible to handle this behavior.
     */
    override suspend fun getItemPage(
        forceRefresh: Boolean,
        page: String?
    ): LiveData<Resource<List<Item>>> {
        return object : NetworkBoundResource<List<Item>, List<Item>>() {

            override fun processResponse(response: List<Item>) = response

            override suspend fun saveCallResults(items: List<Item>) = dao.save(items)

            override fun shouldFetch(data: List<Item>?): Boolean =
                data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb(): List<Item> = dao.getTopUsers()

            override fun createCallAsync(): Deferred<List<Item>> = dataSource.fetchItemPageAsync(page)

        }.build().asLiveData()
    }

}