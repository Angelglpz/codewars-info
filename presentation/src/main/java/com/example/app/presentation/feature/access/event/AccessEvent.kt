package com.example.app.presentation.feature.access.event

internal sealed class AccessEvent {
    class OnTextChanged(val text: String): AccessEvent()
    class OnCheckedChanged(val checked: Boolean): AccessEvent()
}