package com.example.codewarsinfo.navigation

import com.example.app.presentation.util.AccessScreenDestination
import com.example.app.presentation.util.Argument
import com.example.app.presentation.util.HomeScreenDestination

internal sealed class NavigationRoute(val route: String) {
    data object Access : NavigationRoute(AccessScreenDestination)
    data object Home : NavigationRoute("$HomeScreenDestination/{$Argument}") {
        fun navigateWithArgument(userName: String) = "$HomeScreenDestination/$userName"
    }
}