package com.mujapps.multiplatformtester.di

import app.cash.sqldelight.db.SqlDriver
import com.mujapps.multiplatformtester.db.DataBaseDriverFactory
import mujapps.multiplatformtester.db.MultiDb
import org.koin.dsl.module

val dataBaseModule = module {
    single<SqlDriver> {
        DataBaseDriverFactory().createDriver()
    }

    single<MultiDb> { MultiDb(get()) }
}