package com.hurtado.data.di

import com.hurtado.data.repository.AppDispatchers
import com.hurtado.data.repository.ItemRepository
import com.hurtado.data.repository.ItemRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { ItemRepositoryImpl(get(), get()) as ItemRepository }
}