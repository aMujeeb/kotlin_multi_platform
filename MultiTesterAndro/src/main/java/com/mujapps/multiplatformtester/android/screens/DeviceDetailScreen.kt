package com.mujapps.multiplatformtester.android.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mujapps.multiplatformtester.PhoneDetails

@Preview
@Composable
fun DetailsScreen() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        TopToolBar()
        DetailsContainer()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopToolBar() {
    TopAppBar(title = {
        Text(text = "About Android Device")
    })
}

@Composable
fun DetailsContainer() {
    val datItems = makeItems()

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(datItems) { row ->
            RowView(title = row.first, subTitle = row.second)
        }
    }
}

@Composable
fun RowView(title: String, subTitle: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.bodySmall, color = Color.White)
            Text(text = subTitle, style = MaterialTheme.typography.bodySmall, color = Color.Yellow)
        }
    }
    Divider()
}

private fun makeItems(): ArrayList<Pair<String, String>> {
    val phoneDetails = PhoneDetails()
    phoneDetails.logInformation()

    return arrayListOf(
        Pair("Operating System", "${phoneDetails.osName} ${phoneDetails.osVersion}"),
        Pair("Device", phoneDetails.deviceModel),
        Pair("Density", phoneDetails.density.toString())
    )
}