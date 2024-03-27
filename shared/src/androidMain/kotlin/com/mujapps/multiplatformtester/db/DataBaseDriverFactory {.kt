package com.mujapps.multiplatformtester.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import mujapps.multiplatformtester.db.MultiDb

actual class DataBaseDriverFactory(private val mContext: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = MultiDb.Schema,
            context = mContext,
            name = "MultiDb.DataBase.db"
        )
    }
}