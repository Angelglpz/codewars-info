package com.example.codewarsinfo

import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf

@Stable
data class UserConfigState(
    val userName: String = "",
    val keepConnected: Boolean = false
)

val LocalUserPreferences = compositionLocalOf { UserConfigState() }
