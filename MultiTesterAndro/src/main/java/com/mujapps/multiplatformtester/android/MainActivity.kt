package com.mujapps.multiplatformtester.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.mujapps.multiplatformtester.PhoneDetails

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PhoneDetails().logInformation()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //DetailsScreen()
                    //ArticleScreen(articlesVideModel = mArticleViewModel)
                    AppScaffold()
                }
            }
        }
    }
}


/*@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        DetailsScreen()
    }
}*/
