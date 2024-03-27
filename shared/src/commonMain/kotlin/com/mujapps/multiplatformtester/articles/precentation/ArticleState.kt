package com.mujapps.multiplatformtester.articles.precentation

import com.mujapps.multiplatformtester.articles.domain.Article

data class ArticleState (
    val articles : List<Article> = listOf(),
    val loading : Boolean = false,
    val error : String? = null
)