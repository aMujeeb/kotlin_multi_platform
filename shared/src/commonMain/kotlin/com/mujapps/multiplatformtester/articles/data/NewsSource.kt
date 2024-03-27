package com.mujapps.multiplatformtester.articles.data

import kotlinx.serialization.Serializable

@Serializable
data class NewsSource(
    val id : String?,
    val name : String
)
