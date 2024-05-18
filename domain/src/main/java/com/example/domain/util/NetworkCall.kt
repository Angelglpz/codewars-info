package com.example.domain.util

import com.example.domain.exception.CustomFailure
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> networkCall(
    call: suspend () -> T
): ApiResponseStatus<T> {
    return try {
        ApiResponseStatus.Success(call())
    } catch (e: Exception) {
        ApiResponseStatus.Failure(CustomFailure.GenericError)
    }
}