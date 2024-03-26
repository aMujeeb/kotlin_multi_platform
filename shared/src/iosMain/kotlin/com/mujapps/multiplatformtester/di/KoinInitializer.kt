package com.mujapps.multiplatformtester.di

import com.mujapps.multiplatformtester.articles.ArticleViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.KoinContext
import org.koin.core.context.startKoin

fun initKoin() { //Initializing Koin in IOS environment

    val iosModules = sharedKoinModules
    startKoin {
        modules(iosModules)
    }
}

class ArticlesInjector : KoinComponent {
    val articleVideModel: ArticleViewModel by inject()
}