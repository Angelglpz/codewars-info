package com.example.codewarsinfo.navigation.home

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.app.presentation.feature.home.screen.HomeRoute
import com.example.app.presentation.util.KeepConnectedArgument
import com.example.app.presentation.util.UserNameArgument
import com.example.codewarsinfo.LocalUserPreferences
import com.example.codewarsinfo.MainActivityViewModel
import com.example.codewarsinfo.UserConfigState
import com.example.codewarsinfo.navigation.NavigationRoute

internal fun NavGraphBuilder.addHomeNavigation(
    navController: NavController,
    viewModel: MainActivityViewModel
) {
    // A composable destination for the Home route, with arguments for the username and keepConnected parameters.
    composable(
        route = NavigationRoute.Home.route, arguments = listOf(
            navArgument(UserNameArgument) {
                type = NavType.StringType
                defaultValue = viewModel.userConfigState.userName
            },
            navArgument(KeepConnectedArgument) {
                type = NavType.BoolType
                defaultValue = viewModel.userConfigState.keepConnected
            }
        )
    ) {
        val userConfigState = UserConfigState(
            userName = it.arguments?.getString(UserNameArgument) ?: "",
            keepConnected = it.arguments?.getBoolean(KeepConnectedArgument) ?: false
        )
        CompositionLocalProvider(LocalUserPreferences provides userConfigState) {
            HomeRoute()
        }
    }
}