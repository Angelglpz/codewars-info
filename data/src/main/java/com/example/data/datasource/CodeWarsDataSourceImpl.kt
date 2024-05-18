package com.example.data.datasource

import com.example.data.mapper.toModel
import com.example.data.api.CodeWarsInfoApiService
import com.example.domain.exception.CustomFailure
import com.example.domain.model.user.User
import com.example.data.user.UserDTOResponse
import com.example.domain.util.ApiResponseStatus
import com.example.domain.util.networkCall
import javax.inject.Inject

class CodeWarsDataSourceImpl @Inject constructor(
    private val apiService: CodeWarsInfoApiService
) : CodeWarsDataSource {
    override suspend fun getUser(
        userName: String
    ): ApiResponseStatus<User> {
        return when (val result = networkCall { apiService.getUser(userName = userName) }) {
            is ApiResponseStatus.Success -> ApiResponseStatus.Success(result.data.toModel())
            is ApiResponseStatus.Failure -> ApiResponseStatus.Failure(CustomFailure.GenericError)
        }
    }
}