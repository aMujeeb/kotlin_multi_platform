package com.mujapps.multiplatformtester.android.di

import com.mujapps.multiplatformtester.articles.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//To initiate VieModel Objects in the Views
val vieModelsModule = module {
    viewModel {
        ArticleViewModel(get())
    }
}