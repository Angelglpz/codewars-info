package com.example.data.exception.httpexception

import com.example.domain.exception.CustomFailure
import com.example.data.exception.ExceptionHandlerInterface
import com.example.domain.util.ApiResponseStatus
import com.example.domain.util.Exception404
import retrofit2.HttpException
import javax.inject.Inject

class HttpExceptionHandler @Inject constructor() : ExceptionHandlerInterface {
    override fun handleException(exception: Exception): ApiResponseStatus.Failure {
        return if (exception is HttpException) {
            when (exception.code()) {
                Exception404 -> ApiResponseStatus.Failure(CustomFailure.UserNotFound)
                else -> ApiResponseStatus.Failure(CustomFailure.InternalServerError(exception.message()))
            }
        } else {
            ApiResponseStatus.Failure(CustomFailure.GenericError)
        }
    }
}
