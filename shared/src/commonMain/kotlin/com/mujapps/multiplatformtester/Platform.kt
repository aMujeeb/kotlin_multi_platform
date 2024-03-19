package com.mujapps.multiplatformtester

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect class PhoneDetails {
    val osName : String
    val osVersion: String
    val  deviceModel : String
    val density : Int

    fun logInformation()
}