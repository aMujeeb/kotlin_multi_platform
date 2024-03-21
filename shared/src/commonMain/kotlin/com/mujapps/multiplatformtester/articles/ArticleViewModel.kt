package com.mujapps.multiplatformtester.articles

import com.mujapps.multiplatformtester.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : BaseViewModel() {
    // State flows are obligated to have a initial value
    private val _articleState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(loading = true))
    val mArticleState: StateFlow<ArticleState> get() = _articleState

    init {
        getArticles()
    }

    private fun getArticles() {
        mScope.launch {
            delay(1500)
            _articleState.emit(ArticleState(error = "Something Went Wrong"))
            val fetched = fetchArticles()
            delay(1000) //Test delay for imitate network delay
            _articleState.emit(ArticleState(articles = fetched))
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
            imageUrl = "https://www.gstatic.com/webp/gallery/4.jpg"
        ),
        Article(
            title = "Samsung details 'Galaxy AI'",
            desc = "In a new blog post, Samsung previewed what it calls a new era of mobile phones",
            date = "2023-11-09",
            imageUrl = "https://www.gstatic.com/webp/gallery/5.jpg"
        ),
        Article(
            title = "SL Cricket News",
            desc = "Wanindu Hasaranga banned for few months. Nice",
            date = "2023-11-09",
            imageUrl = "https://www.gstatic.com/webp/gallery/3.jpg"
        )
    )
}