package com.example.network.ui.components

import CatCard
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.network.ui.viewmodel.CatViewModel

@Composable
fun CatListScreen(
    viewModel: CatViewModel = hiltViewModel()
) {
    val catList by viewModel.cats.collectAsState()

    LazyColumn {
        items(catList) { cat ->
            CatCard(imageUrl = cat.url, contentDescription = "Cat image")
        }
    }
}
