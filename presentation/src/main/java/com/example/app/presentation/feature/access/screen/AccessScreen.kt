package com.example.app.presentation.feature.access.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.app.presentation.R
import com.example.app.presentation.feature.access.event.HomeEvent
import com.example.app.presentation.feature.access.state.AccessState
import com.example.app.presentation.feature.access.viewmodel.AccessViewModel
import com.example.app.presentation.theme.CodeWarsInfoTheme
import com.example.app.presentation.theme.ImageAspectRatio
import com.example.app.presentation.theme.PaddingMedium

@Composable
fun AccessRoute(
    viewModel: AccessViewModel = hiltViewModel(),
    onContinueButtonClicked: (String, Boolean) -> Unit
) {
    AccessScreen(
        state = viewModel.state,
        onEvent = viewModel::onEvent,
        onContinueButtonClicked = onContinueButtonClicked
    )
}

@Composable
private fun AccessScreen(
    state: AccessState,
    onEvent: (HomeEvent) -> Unit,
    onContinueButtonClicked: (String, Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(PaddingMedium)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column {
            Image(
                modifier = Modifier
                    .aspectRatio(ImageAspectRatio)
                    .padding(bottom = PaddingMedium),
                painter = painterResource(id = R.drawable.ic_codewars),
                contentDescription = ""
            )
            TextField(
                modifier = Modifier
                    .padding(PaddingMedium)
                    .align(Alignment.CenterHorizontally),
                value = state.userName, onValueChange = { onEvent(HomeEvent.OnTextChanged(it)) },
                placeholder = {
                    Text(text = stringResource(R.string.username_placeholder_text))
                }, singleLine = true
            )
            Checkbox(
                checked = state.keepConnectedChecked,
                onCheckedChange = { onEvent(HomeEvent.OnCheckedChanged(it)) }
            )
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(PaddingMedium),
                onClick = {
                    onContinueButtonClicked(state.userName, state.keepConnectedChecked)
                }) {
                Text(text = stringResource(R.string.continue_button_text))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccessScreenPreview() {
    CodeWarsInfoTheme {
        AccessScreen(AccessState("usuario"), {}, {_, _ -> })
    }
}