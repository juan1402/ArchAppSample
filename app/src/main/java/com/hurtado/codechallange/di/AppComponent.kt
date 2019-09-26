package com.hurtado.codechallange.di

import com.hurtado.data.di.createRemoteModule
import com.hurtado.data.di.localModule
import com.hurtado.data.di.repositoryModule
import com.hurtado.features.home.di.homeModule

val appComponent = listOf(
    createRemoteModule("https://marlove.net/e/mock/v1/"),
    repositoryModule,
    localModule,
    homeModule
)