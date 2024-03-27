package com.mujapps.multiplatformtester.articles.articles_di

import com.mujapps.multiplatformtester.articles.precentation.ArticleViewModel
import com.mujapps.multiplatformtester.articles.data.ArticlesDataSource
import com.mujapps.multiplatformtester.articles.data.repository.ArticlesRepository
import com.mujapps.multiplatformtester.articles.data.services.ArticlesService
import com.mujapps.multiplatformtester.articles.domain.usecases.ArticlesUseCase
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