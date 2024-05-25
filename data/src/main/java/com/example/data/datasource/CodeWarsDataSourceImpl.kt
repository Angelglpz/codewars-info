package com.example.data.datasource

import com.example.data.mapper.toModel
import com.example.data.api.CodeWarsInfoApiService
import com.example.data.exception.ExceptionHandler
import com.example.domain.exception.CustomFailure
import com.example.domain.model.user.User
import com.example.domain.util.ApiResponseStatus
import com.example.domain.util.Exception404
import retrofit2.HttpException
import javax.inject.Inject

internal class CodeWarsDataSourceImpl @Inject constructor(
    private val apiService: CodeWarsInfoApiService,
    private val exceptionHandler: ExceptionHandler
) : CodeWarsDataSource {
    override suspend fun getUser(
        userName: String
    ): ApiResponseStatus<User> {
        return try {
            apiService.getUser(userName = userName).let {
                ApiResponseStatus.Success(it.toModel())
            }
        } catch (e: Exception) {
            exceptionHandler.handleException(e)
        }
    }
}