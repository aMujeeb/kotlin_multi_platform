package com.mujapps.multiplatformtester.articles

import kotlinx.serialization.Serializable

@Serializable
data class NewsSource(
    val id : String?,
    val name : String
)
