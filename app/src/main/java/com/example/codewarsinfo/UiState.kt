package com.example.codewarsinfo

import com.example.codewarsinfo.navigation.NavigationRoute

internal sealed class UIState {
    data object Loading : UIState()
    data class Success(val route: String = NavigationRoute.Access.route) : UIState()
}