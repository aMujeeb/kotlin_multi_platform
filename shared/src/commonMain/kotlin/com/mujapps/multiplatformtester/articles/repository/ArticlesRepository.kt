package com.mujapps.multiplatformtester.articles.repository

import com.mujapps.multiplatformtester.articles.ArticleRaw
import com.mujapps.multiplatformtester.articles.datasource.ArticlesDataSource
import com.mujapps.multiplatformtester.services.ArticlesService

class ArticlesRepository(private val dataSource: ArticlesDataSource, private val articleService: ArticlesService) {

    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {
        if (forceFetch) {
            dataSource.clearAllArticles()
            return fetchFreshArticlesList()
        }
        val articlesDb = dataSource.getAllArticles()
        println("Got ${articlesDb.size}")

        if (articlesDb.isEmpty()) {
            return fetchFreshArticlesList()
        }

        return articlesDb
    }

    private suspend fun fetchFreshArticlesList(): List<ArticleRaw> {
        val fetchedArticles = articleService.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}