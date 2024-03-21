package com.mujapps.multiplatformtester.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mujapps.multiplatformtester.Greeting
import com.mujapps.multiplatformtester.PhoneDetails
import com.mujapps.multiplatformtester.android.screens.ArticleScreen
import com.mujapps.multiplatformtester.android.screens.DetailsScreen
import com.mujapps.multiplatformtester.articles.ArticleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PhoneDetails().logInformation()

        val mArticleViewModel: ArticleViewModel by viewModels()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //DetailsScreen()
                    ArticleScreen(articlesVideModel = mArticleViewModel)
                }
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        DetailsScreen()
    }
}
