package com.hurtado.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*
import java.util.concurrent.TimeUnit

@Entity
data class Item(

    @PrimaryKey
    @SerializedName("_id")
    val id: String,

    @SerializedName("text")
    var text: String,

    @SerializedName("img")
    var image: String,

    @SerializedName("confidence")
    var confidence: String,

    var lastRefreshed: Date

) {

    /**
     * We consider that an [Item] is outdated when the last time
     * we fetched it was more than 30 minutes
     */
    fun haveToRefreshFromNetwork() : Boolean
            = TimeUnit.MILLISECONDS.toMinutes(Date().time - lastRefreshed.time) >= 30

}