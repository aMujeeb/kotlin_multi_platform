package com.mujapps.multiplatformtester.articles

import com.mujapps.multiplatformtester.BaseViewModel
import com.mujapps.multiplatformtester.services.ArticlesService
import com.mujapps.multiplatformtester.usecases.ArticlesUseCase
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticleViewModel(private val articlesUseCase: ArticlesUseCase) : BaseViewModel() {
    // State flows are obligated to have a initial value
    private val _articleState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(loading = true))
    val mArticleState: StateFlow<ArticleState> get() = _articleState

    init {
        getArticles()
    }

    private fun getArticles() {
        mScope.launch {
            val fetchedArticles = articlesUseCase.getArticles()
            _articleState.emit(ArticleState(articles = fetchedArticles))
        }
    }

    //Mock Data's temporary
    private suspend fun fetchArticles() = mockArticles

    private val mockArticles = listOf(
        Article(
            title = "Stock Market Today",
            desc = "Futures were higher in premarket",
            date = "2023-11-09",
            imageUrl = "https://media.istockphoto.com/id/1492180527/photo/digital-marketing-commerce-online-sale-concept-promotion-of-products-or-services-through.jpg?s=1024x1024&w=is&k=20&c=H27lM3bpDZ4SoLPRST72-Lp7rpFsa5L4KgvcP8BF62M="
        ),
        Article(
            title = "Best iPhone Deals",
            desc = "Apple's smartphones rarely go on Sale.",
            date = "2023-11-09",
            imageUrl = "https://media.istockphoto.com/id/1776879677/photo/close-up-young-man-hand-hold-smartphone-and-use-application-of-e-commerce-to-working-about.jpg?s=1024x1024&w=is&k=20&c=f6GC2IfoZK8pz6LO9df2p3fAhen4OX8YSmlbvht3ZlQ="
        ),
        Article(
            title = "Samsung details 'Galaxy AI'",
            desc = "In a new blog post, Samsung previewed what it calls a new era of mobile phones",
            date = "2023-11-09",
            imageUrl = "https://media.istockphoto.com/id/1436264410/photo/person-working-with-search-engine-optimization-seo-with-social-media-content-and.jpg?s=1024x1024&w=is&k=20&c=j3bvKKS_r-uWro_RyLaARWeL5PIuJrPe_4pDf2Yzaio="
        ),
        Article(
            title = "SL Cricket News",
            desc = "Wanindu Hasaranga banned for few months. Nice",
            date = "2023-11-09",
            imageUrl = "https://media.istockphoto.com/id/1473508665/photo/administration-teamwork-office-documents-or-people-review-financial-data-finance-funding-or.jpg?s=1024x1024&w=is&k=20&c=7S4FyaQ0_TBEf4mRFuguACbapN2U2u8Kt_DyB-laGUc="
        )
    )
}