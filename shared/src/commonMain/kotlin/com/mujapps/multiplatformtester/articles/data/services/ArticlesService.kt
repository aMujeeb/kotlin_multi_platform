package com.mujapps.multiplatformtester.articles.data.services

import com.mujapps.multiplatformtester.articles.data.ArticleRaw
import com.mujapps.multiplatformtester.articles.data.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val mHttpClient: HttpClient) {

    private val country = "us"
    private val articleCategory = "business"
    private val apiKey = "3ffd87b0318848499898ec56b3c6c402"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse =
            mHttpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$articleCategory&apiKey=$apiKey").body()
        return response.articles
    }
}