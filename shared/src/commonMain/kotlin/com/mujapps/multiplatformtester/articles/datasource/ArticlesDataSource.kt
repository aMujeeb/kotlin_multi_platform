package com.mujapps.multiplatformtester.articles.datasource

import com.mujapps.multiplatformtester.articles.ArticleRaw
import mujapps.multiplatformtester.db.MultiDb

class ArticlesDataSource(private val database: MultiDb) {

    fun getAllArticles(): List<ArticleRaw> =
        database.multiDbQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    private fun mapToArticleRaw(title: String, desc: String?, date: String, url: String?): ArticleRaw = ArticleRaw(
        title = title,
        description = desc,
        publishedAt = date,
        urlToImage = url,
        author = "",
        content = "",
        url = "",
        source = null
    )

    fun insertArticles(articles: List<ArticleRaw>) {
        database.multiDbQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.multiDbQueries.insertArticle(
            title = articleRaw.title,
            desc = articleRaw.description,
            date = articleRaw.publishedAt ?: "",
            imageUrl = articleRaw.urlToImage
        )
    }

    fun clearAllArticles() = database.multiDbQueries.removeAllArticles()
}