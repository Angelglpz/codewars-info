package com.example.codewarsinfo.common.navigationbar.viewmodel

import androidx.lifecycle.ViewModel
import com.example.codewarsinfo.common.navigationbar.event.CodeWarsInfoNavigationBarEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class CodeWarsInfoNavigationBarViewModel @Inject constructor(): ViewModel() {

    fun onEvent(event: CodeWarsInfoNavigationBarEvent) {
        when (event) {
            is CodeWarsInfoNavigationBarEvent.OnHomeSelected -> {
                // Handle the Home selected event.
            }
            is CodeWarsInfoNavigationBarEvent.OnProfileSelected -> {
                // Handle the Profile selected event.
            }
        }
    }

}