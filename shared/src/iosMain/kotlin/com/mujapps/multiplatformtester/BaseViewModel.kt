package com.mujapps.multiplatformtester

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

actual open class BaseViewModel {
    actual val mScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO) // Since IOS do not have CoRoutines. Manually a Coroutine is created which has an IO dispatch
    //Can use to sent HTTP request and DB query

    //Manually have to create functions to support lifecycle awareness to behave as similar to Android co-routine scope

    //In IOS this should be manually called to destroy the scope
    fun clear() {
        mScope.cancel()
    }
}