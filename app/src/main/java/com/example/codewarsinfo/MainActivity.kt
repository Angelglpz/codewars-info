package com.example.codewarsinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.app.presentation.theme.CodeWarsInfoTheme
import com.example.app.presentation.theme.PaddingSmall
import com.example.codewarsinfo.common.navigationbar.component.CodeWarsNavigationBar
import com.example.codewarsinfo.navigation.CodeWarsInfoNavigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * MainActivity is the entry point of the application.
 * It is annotated with @AndroidEntryPoint to enable dependency injection via Hilt.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /**
     * The onCreate function is called when the activity is first created.
     * It sets up the splash screen, edge-to-edge display, and the main content of the activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // ViewModel for this activity, provided by Hilt.
        val viewModel: MainActivityViewModel by viewModels()
        // Install a splash screen for the activity.
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        // Set the condition for keeping the splash screen on.
        splashScreen.setKeepOnScreenCondition {
            when (viewModel.uiState) {
                is UIState.Success -> false
                is UIState.Loading -> true
            }
        }
        // Enable edge-to-edge display for the activity.
        enableEdgeToEdge()

        setContent {
            CodeWarsInfoTheme(dynamicColor = false) {
                if (viewModel.uiState is UIState.Success) {
                    CodeWarsInfoNavigation(
                        startDestinationRoute = (viewModel.uiState as UIState.Success).route,
                        userConfigState = viewModel.userConfigState,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}