package com.hurtado.codechallange

import android.app.Application
import com.hurtado.codechallange.di.appComponent
import org.koin.android.ext.android.startKoin

class CodeChallengeApp: Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
        BuildConfig.ApiKey
    }

    // CONFIGURATION ---
    open fun configureDi() =
        startKoin(this, provideComponent())

    // PUBLIC API ---
    open fun provideComponent() = appComponent

}