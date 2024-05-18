package com.example.app.presentation.feature.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.app.presentation.R
import com.example.app.presentation.feature.home.event.HomeEvent
import com.example.app.presentation.feature.home.state.HomeState
import com.example.app.presentation.feature.home.viewmodel.HomeViewModel
import com.example.app.presentation.theme.CodeWarsInfoTheme
import com.example.app.presentation.theme.PaddingMedium
import com.example.app.presentation.theme.PaddingSmall

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(state = viewModel.state, onEvent = viewModel::onEvent)
}

@Composable
private fun HomeScreen(state: HomeState, onEvent: (HomeEvent) -> Unit) {
    Box(
        modifier = Modifier
            .padding(PaddingMedium)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column {
            TextField(
                value = state.userName, onValueChange = { onEvent(HomeEvent.OnTextChanged(it)) },
                placeholder = {
                    Text(text = stringResource(R.string.username_placeholder_text))
                }, singleLine = true
            )
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(PaddingMedium),
                onClick = { onEvent(HomeEvent.OnButtonClick(state.userName)) }) {
                Text(text = stringResource(R.string.continue_button_text))
            }
        }
    }
}

@Composable
private fun ButtonTest(onEvent: (HomeEvent) -> Unit) {
    Button(onClick = { onEvent(HomeEvent.OnButtonClick("angelglpz")) }) {
        Text(text = "Mostrar nombre")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CodeWarsInfoTheme {
        HomeScreen(HomeState("usuario")) {}
    }
}