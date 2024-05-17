package com.example.domain.util

import com.example.domain.exception.CustomFailure

sealed interface ApiResponseStatus<out T> {
    class Success<T>(val data: T) : ApiResponseStatus<T>
    class Failure(val failure: CustomFailure) : ApiResponseStatus<Nothing>
}