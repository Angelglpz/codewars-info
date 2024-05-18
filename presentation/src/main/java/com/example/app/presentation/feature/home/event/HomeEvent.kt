package com.example.app.presentation.feature.home.event

internal sealed class HomeEvent {
    class OnButtonClick(val text: String): HomeEvent()
    class OnTextChanged(val text: String): HomeEvent()
}