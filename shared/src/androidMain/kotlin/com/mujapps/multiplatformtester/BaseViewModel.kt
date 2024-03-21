package com.mujapps.multiplatformtester

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class BaseViewModel :  ViewModel(){
    actual val mScope: CoroutineScope
        get() = viewModelScope
}