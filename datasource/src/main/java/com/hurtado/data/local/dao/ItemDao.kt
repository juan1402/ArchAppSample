package com.hurtado.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.hurtado.data.entities.Item
import java.util.*

@Dao
abstract class ItemDao: BaseDao<Item>() {

    @Query("SELECT * FROM Item ORDER BY text ASC LIMIT 10")
    abstract suspend fun getTopUsers(): List<Item>

    @Query("SELECT * FROM Item WHERE id = :id LIMIT 1")
    abstract suspend fun getUser(id: String): Item

    // ---

    /**
     * Each time we save an user, we update its 'lastRefreshed' field
     * This allows us to know when we have to refresh its data
     */

    suspend fun save(item: Item) {
        insert(item.apply { lastRefreshed = Date() })
    }

    suspend fun save(users: List<Item>) {
        insert(users.apply { forEach { it.lastRefreshed = Date() } })
    }

}