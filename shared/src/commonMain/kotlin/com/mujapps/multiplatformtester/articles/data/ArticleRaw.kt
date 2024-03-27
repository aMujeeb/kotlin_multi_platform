package com.mujapps.multiplatformtester.articles.data

import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    val source: NewsSource?,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
)
