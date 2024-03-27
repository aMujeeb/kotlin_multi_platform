package com.mujapps.multiplatformtester.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import mujapps.multiplatformtester.db.MultiDb

actual class DataBaseDriverFactory {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = MultiDb.Schema,
            name = "MultiDb.DataBase.db"
        )
}