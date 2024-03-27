package com.mujapps.multiplatformtester.articles.articles_di

import com.mujapps.multiplatformtester.articles.ArticleViewModel
import com.mujapps.multiplatformtester.articles.datasource.ArticlesDataSource
import com.mujapps.multiplatformtester.articles.repository.ArticlesRepository
import com.mujapps.multiplatformtester.services.ArticlesService
import com.mujapps.multiplatformtester.usecases.ArticlesUseCase
import org.koin.dsl.module

val articleModule = module {

    single<ArticlesService> {
        ArticlesService(get())
    }

    single<ArticlesUseCase> {
        ArticlesUseCase(get())
    }

    single<ArticleViewModel> {
        ArticleViewModel(get())
    }

    single<ArticlesDataSource> {
        ArticlesDataSource(get())
    }

    single<ArticlesRepository> {
        ArticlesRepository(get(), get())
    }
}