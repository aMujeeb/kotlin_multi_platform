package com.mujapps.multiplatformtester.usecases

import com.mujapps.multiplatformtester.articles.Article
import com.mujapps.multiplatformtester.articles.ArticleRaw
import com.mujapps.multiplatformtester.articles.repository.ArticlesRepository
import com.mujapps.multiplatformtester.services.ArticlesService
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val artRepo: ArticlesRepository) {
    suspend fun getArticles(forceToRefresh : Boolean): List<Article> {
        val articleRaw = artRepo.getArticles(forceToRefresh)
        return mapArticles(articleRaw)
    }

    private fun mapArticles(articleRaw: List<ArticleRaw>): List<Article> = articleRaw.map {
        Article(
            title = it.title,
            desc = it.description ?: "Click to find out more",
            date = it.publishedAt?.let { date -> getDaysAgoValue(date) } ?: "-",
            imageUrl = it.urlToImage ?: ""
        )
    }

    private fun getDaysAgoValue(dateValue: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(dateValue).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        return when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }
    }
}