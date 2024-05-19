package com.example.app.presentation.feature.access.event

internal sealed class HomeEvent {
    class OnTextChanged(val text: String): HomeEvent()
}