package com.mujapps.multiplatformtester.android.di

import app.cash.sqldelight.db.SqlDriver
import com.mujapps.multiplatformtester.db.DataBaseDriverFactory
import mujapps.multiplatformtester.db.MultiDb
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> {
        DataBaseDriverFactory(androidContext()).createDriver()  //androidContext--> From Application class
    }

    single<MultiDb> { MultiDb(get()) }
}