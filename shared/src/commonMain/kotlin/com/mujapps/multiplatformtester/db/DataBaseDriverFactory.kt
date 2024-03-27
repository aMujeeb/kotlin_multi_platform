package com.mujapps.multiplatformtester.db

import app.cash.sqldelight.db.SqlDriver

expect class DataBaseDriverFactory {
    fun createDriver() : SqlDriver
}