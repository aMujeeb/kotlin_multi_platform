package com.mujapps.multiplatformtester.articles.repository

import com.mujapps.multiplatformtester.articles.ArticleRaw
import com.mujapps.multiplatformtester.articles.datasource.ArticlesDataSource
import com.mujapps.multiplatformtester.services.ArticlesService

class ArticlesRepository(private val dataSource: ArticlesDataSource, private val articleService: ArticlesService) {

    suspend fun getArticles(): List<ArticleRaw> {
        val articlesDb = dataSource.getAllArticles()

        println("Got ${articlesDb.size}")

        if (articlesDb.isEmpty()) {
            val fetchedArticles = articleService.fetchArticles()

            dataSource.insertArticles(fetchedArticles)
            return fetchedArticles
        }

        return articlesDb
    }
}