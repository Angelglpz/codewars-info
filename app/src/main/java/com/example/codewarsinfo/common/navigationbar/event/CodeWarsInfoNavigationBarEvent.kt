package com.example.codewarsinfo.common.navigationbar.event

internal sealed class CodeWarsInfoNavigationBarEvent {
    data object OnHomeSelected : CodeWarsInfoNavigationBarEvent()
    data object OnProfileSelected : CodeWarsInfoNavigationBarEvent()
}


