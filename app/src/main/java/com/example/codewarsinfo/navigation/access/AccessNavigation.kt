package com.example.codewarsinfo.navigation.access

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.app.presentation.feature.access.screen.AccessRoute
import com.example.app.presentation.util.KeepConnectedArgument
import com.example.app.presentation.util.UserNameArgument
import com.example.codewarsinfo.MainActivityViewModel
import com.example.codewarsinfo.UserConfigState
import com.example.codewarsinfo.navigation.NavigationRoute

internal fun NavGraphBuilder.addAccessNavigation(navController: NavController, userConfigState: UserConfigState, viewModel: MainActivityViewModel) {
    // A composable destination for the Access route.
    composable(route = NavigationRoute.Access.route) {
        AccessRoute(onContinueButtonClicked = { userName, keepConnected ->
            // Navigate to the Home route with the username and keepConnected parameters when the Continue button is clicked.
            navController.navigate(NavigationRoute.Home.navigateWithArgument(userName, keepConnected))
        })
    }
}