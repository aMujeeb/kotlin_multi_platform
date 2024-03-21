package com.mujapps.multiplatformtester

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() { //this is the constructor representation

    val mScope : CoroutineScope
}