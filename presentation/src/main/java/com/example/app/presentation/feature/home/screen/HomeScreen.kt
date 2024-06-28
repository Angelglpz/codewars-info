package com.example.app.presentation.feature.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.app.presentation.common.LoadingScreen
import com.example.app.presentation.feature.home.state.HomeState
import com.example.app.presentation.feature.home.viewmodel.HomeViewModel
import com.example.app.presentation.theme.CodeWarsInfoTheme

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
//    val lifecycleEvent = rememberLifecycleEvent()
//    LaunchedEffect(lifecycleEvent) {
//        if (lifecycleEvent == Lifecycle.Event.ON_RESUME || lifecycleEvent == Lifecycle.Event.ON_CREATE) {
//            viewModel.fetchUserName()
//        }
//    }
    //TODO REVISAR ESTO
    if (viewModel.state.showLoading) {
        LoadingScreen()
    } else {
        HomeScreen(state = viewModel.state)
    }


}

@Composable
private fun HomeScreen(state: HomeState) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Honor ${state.honor}")
    }
}

@Composable
fun rememberLifecycleEvent(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current): Lifecycle.Event {
    var state by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            state = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    return state
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    CodeWarsInfoTheme {
        HomeScreen(HomeState())
    }
}