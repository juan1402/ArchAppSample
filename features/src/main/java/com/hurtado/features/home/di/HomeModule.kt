package com.hurtado.features.home.di

import com.hurtado.features.home.HomeViewModel
import com.hurtado.features.home.domain.GetItemUseCase
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val homeModule = module {
    factory { GetItemUseCase(get()) }
    viewModel { HomeViewModel(get(), get()) }
}