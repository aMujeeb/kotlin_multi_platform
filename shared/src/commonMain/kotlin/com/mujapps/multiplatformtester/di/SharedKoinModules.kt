package com.mujapps.multiplatformtester.di

import com.mujapps.multiplatformtester.articles.articles_di.articleModule

val sharedKoinModules = listOf(
    articleModule, networkModule
)