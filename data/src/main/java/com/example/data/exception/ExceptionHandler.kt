package com.example.data.exception

import android.util.Log
import com.example.domain.exception.CustomFailure
import com.example.domain.util.ApiResponseStatus
import javax.inject.Inject

class ExceptionHandler @Inject constructor(
    private val exceptionHandlersMap: Map<Class<out Exception>, @JvmSuppressWildcards ExceptionHandlerInterface>
) {

    fun handleException(exception: Exception): ApiResponseStatus.Failure {
        return exceptionHandlersMap[exception::class.java]?.handleException(exception)
            ?: ApiResponseStatus.Failure(CustomFailure.GenericError)
    }
}