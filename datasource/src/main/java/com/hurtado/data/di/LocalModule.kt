package com.hurtado.data.di

import com.hurtado.data.local.ItemDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

private const val DATABASE = "DATABASE"

val localModule = module {

    single(DATABASE) { ItemDataBase.buildDatabase(androidContext()) }
    factory { (get(DATABASE) as ItemDataBase).userDao() }

}