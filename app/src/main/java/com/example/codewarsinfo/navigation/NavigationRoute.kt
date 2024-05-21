package com.example.codewarsinfo.navigation

import com.example.app.presentation.util.AccessScreenDestination
import com.example.app.presentation.util.UserNameArgument
import com.example.app.presentation.util.KeepConnectedArgument
import com.example.app.presentation.util.HomeScreenDestination

internal sealed class NavigationRoute(val route: String) {
    data object Access : NavigationRoute(AccessScreenDestination)
    data object Home : NavigationRoute("$HomeScreenDestination/{$UserNameArgument}/{$KeepConnectedArgument}") {
        fun navigateWithArgument(userName: String, keepConnected: Boolean) =
            "$HomeScreenDestination/$userName/$keepConnected"
    }
}