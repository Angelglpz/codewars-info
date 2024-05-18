package com.example.app.presentation.feature.home.event

sealed class HomeEvent {
    class OnButtonClick(val value: String): HomeEvent()
}