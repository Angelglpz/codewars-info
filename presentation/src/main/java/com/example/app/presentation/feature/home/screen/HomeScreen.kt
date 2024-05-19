package com.example.app.presentation.feature.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.app.presentation.common.LoadingScreen
import com.example.app.presentation.feature.home.state.HomeState
import com.example.app.presentation.feature.home.viewmodel.HomeViewModel
import com.example.app.presentation.theme.CodeWarsInfoTheme

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    if (viewModel.state.showLoading) {
        LoadingScreen()
    }
    HomeScreen(state = viewModel.state)
}

@Composable
private fun HomeScreen(state: HomeState) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Honor ${state.honor}")
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    CodeWarsInfoTheme {
        HomeScreen(HomeState())
    }
}