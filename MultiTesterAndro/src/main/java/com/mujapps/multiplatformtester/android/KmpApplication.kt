package com.mujapps.multiplatformtester.android

import android.app.Application
import com.mujapps.multiplatformtester.android.di.vieModelsModule
import com.mujapps.multiplatformtester.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KmpApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val requiredModules = sharedKoinModules + vieModelsModule

        startKoin {
            androidContext(this@KmpApplication)
            modules(requiredModules)
        }
    }
}