package com.mujapps.multiplatformtester.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mujapps.multiplatformtester.android.screens.ArticleScreen
import com.mujapps.multiplatformtester.android.screens.DetailsScreen
import com.mujapps.multiplatformtester.android.screens.Screens
import com.mujapps.multiplatformtester.articles.ArticleViewModel

@Composable
fun AppScaffold(articleViewModel: ArticleViewModel) {

    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            articleViewModel = articleViewModel
        )
    }
}

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier, articleViewModel: ArticleViewModel) {
    NavHost(navController = navController, startDestination = Screens.ARTICLES.route, modifier = modifier) {
        composable(Screens.ARTICLES.route) {
            ArticleScreen(onAboutButtonClick = { navController.navigate(Screens.ABOUT_DEVICE.route) }, articlesVideModel = articleViewModel)
        }
        composable(Screens.ABOUT_DEVICE.route) {
            DetailsScreen(onBackButtonClick = {
                navController.popBackStack()
            })
        }
    }
}