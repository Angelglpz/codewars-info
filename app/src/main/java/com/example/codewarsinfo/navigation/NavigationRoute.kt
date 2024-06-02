package com.example.codewarsinfo.navigation

import android.graphics.drawable.Icon
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.app.presentation.util.AccessScreenDestination
import com.example.app.presentation.util.UserNameArgument
import com.example.app.presentation.util.KeepConnectedArgument
import com.example.app.presentation.util.HomeScreenDestination
import com.example.app.presentation.util.IntermediateScreenDestination
import com.example.codewarsinfo.R

internal sealed class NavigationRoute(
    val route: String,
    @StringRes val label: Int? = null,
    val icon: ImageVector? = null
) {
    data object Access : NavigationRoute(AccessScreenDestination)
    data object Home : NavigationRoute(
        route = "$HomeScreenDestination/{$UserNameArgument}/{$KeepConnectedArgument}",
        label = R.string.home_screen_label,
        icon = Icons.Default.Home
    ) {
        fun navigateWithArgument(userName: String, keepConnected: Boolean = false) =
            "$HomeScreenDestination/$userName/$keepConnected"

        val arguments = listOf(
            navArgument(UserNameArgument) {
                type = NavType.StringType
            },
            navArgument(KeepConnectedArgument) {
                type = NavType.BoolType
            }
        )
    }

    data object Intermediate : NavigationRoute(IntermediateScreenDestination)
}