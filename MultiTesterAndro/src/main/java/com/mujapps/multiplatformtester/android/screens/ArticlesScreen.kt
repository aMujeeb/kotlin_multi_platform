package com.mujapps.multiplatformtester.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mujapps.multiplatformtester.articles.Article
import com.mujapps.multiplatformtester.articles.ArticleViewModel


@Composable
fun ArticleScreen(articlesVideModel: ArticleViewModel) {

    val mArticleState = articlesVideModel.mArticleState.collectAsState()

    Column {
        AppBar()
        if (mArticleState.value.loading) {
            ProgressLoader()
        }
        if (mArticleState.value.error.isNullOrEmpty().not()) {
            DisplayErrorMessage(mArticleState.value.error ?: "")
        }
        if (mArticleState.value.articles.isNotEmpty())
            ArticlesListView(articlesVideModel.mArticleState.value.articles)
    }
}

@Composable
fun ArticlesListView(articles: List<Article>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles) { article ->
            ArticleItemView(articleItem = article)
        }
    }
}

@Composable
fun ArticleItemView(articleItem: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        AsyncImage(model = articleItem.imageUrl, contentDescription = "Article Image")

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = articleItem.title, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp))

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = articleItem.desc, style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 14.sp))

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = articleItem.date,
            style = TextStyle(fontWeight = FontWeight.Thin, color = Color.Gray, fontSize = 14.sp),
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun DisplayErrorMessage(error: String) {
    Box(modifier = Modifier, contentAlignment = Alignment.Center) {
        Text(text = error, style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar() {
    TopAppBar(title = {
        Text(text = "Articles", style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center))
    })
}

@Composable
fun ProgressLoader() {
    CircularProgressIndicator(
        modifier = Modifier.size(64.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        trackColor = MaterialTheme.colorScheme.secondary
    )
}