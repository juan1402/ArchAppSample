package com.hurtado.data.local

import android.content.Context
import androidx.room.*
import com.hurtado.data.local.converter.Converters
import com.hurtado.data.local.dao.ItemDao
import com.hurtado.data.entities.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ItemDataBase: RoomDatabase() {

    // DAO
    abstract fun userDao(): ItemDao

    companion object {

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ItemDataBase::class.java, "CodeChallenge.db")
                .build()
    }
}