package com.example.codewarsinfo.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.util.trace
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.app.presentation.feature.access.screen.AccessRoute
import com.example.app.presentation.theme.PaddingSmall
import com.example.codewarsinfo.LocalUserPreferences
import com.example.codewarsinfo.MainActivityViewModel
import com.example.codewarsinfo.UserConfigState
import com.example.codewarsinfo.common.navigationbar.component.CodeWarsNavigationBar
import com.example.codewarsinfo.navigation.access.addAccessNavigation
import com.example.codewarsinfo.navigation.home.addHomeNavigation
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * This is a Composable function that handles the navigation within the CodeWarsInfo application.
 *
 * @param userName The username of the user. If the username is empty, the user is navigated to the Access route.
 *                 Otherwise, the user is navigated to the Home route with the username and keepConnected parameters.
 */
@Composable
internal fun CodeWarsInfoNavigation(startDestinationRoute: String, userConfigState: UserConfigState, viewModel: MainActivityViewModel) {
    // Remember a NavController that allows navigation between composables.
    val navController = rememberNavController()

    // Scaffold provides a framework for material design layouts.
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingSmall),
        bottomBar = {
            //if (userName.isNotEmpty() && navController.currentDestination?.route != NavigationRoute.Access.route) {
                CodeWarsNavigationBar(navController = navController, viewModel = viewModel)
            //}
        }
    ) { innerPadding ->
        // Box is a layout composable that stacks its children on top of each other.
        Box(modifier = Modifier.padding(innerPadding)) {
            // A NavHost is a composable that hosts a navigation graph. It is responsible for displaying the correct destination from the graph.
            NavHost(
                navController = navController,
                startDestination = startDestinationRoute
            ) {
                addAccessNavigation(navController, userConfigState, viewModel)
                addHomeNavigation(navController, viewModel)
            }
        }
    }
}