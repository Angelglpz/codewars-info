package com.example.domain.util

import com.example.domain.exception.CustomFailure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> networkCall(
    call: suspend () -> T
): ApiResponseStatus<T> {
    return try {
        val result = withContext(Dispatchers.IO) {
            call()
        }
        ApiResponseStatus.Success(result)
    } catch (e: Exception) {
        ApiResponseStatus.Failure(CustomFailure.GenericError)
    }
}