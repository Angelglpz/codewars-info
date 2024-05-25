package com.example.data.exception.genericexception

import com.example.domain.exception.CustomFailure
import com.example.data.exception.ExceptionHandlerInterface
import com.example.domain.util.ApiResponseStatus
import javax.inject.Inject

class GenericExceptionHandler @Inject constructor() : ExceptionHandlerInterface {
    override fun handleException(exception: Exception): ApiResponseStatus.Failure =
        ApiResponseStatus.Failure(CustomFailure.GenericError)
}