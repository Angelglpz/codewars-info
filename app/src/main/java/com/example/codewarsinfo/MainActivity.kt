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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.app.presentation.theme.CodeWarsInfoTheme
import com.example.app.presentation.theme.PaddingSmall
import com.example.codewarsinfo.navigation.CodeWarsInfoNavigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition {
            viewModel.showSplash.value
        }
        enableEdgeToEdge()
        setContent {
            CodeWarsInfoTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(PaddingSmall)
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        CodeWarsInfoNavigation()
                    }
                }
            }
        }
    }
}