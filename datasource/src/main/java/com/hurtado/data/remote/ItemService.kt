package com.hurtado.data.remote


import com.hurtado.data.entities.Item
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemService {

    @GET("items")
    fun fetchItemPageAsync(@Query("max_id") maxId: String?): Deferred<List<Item>>

}