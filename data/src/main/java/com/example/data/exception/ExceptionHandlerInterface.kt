package com.example.data.exception

import com.example.data.exception.di.ExceptionHandlerModule
import com.example.domain.util.ApiResponseStatus
import dagger.Component

interface ExceptionHandlerInterface {
    fun handleException(exception: Exception): ApiResponseStatus.Failure
}