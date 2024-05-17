package com.example.domain.datasource

import com.example.domain.api.CodeWarsInfoApiService
import com.example.domain.response.user.UserDTOResponse
import com.example.domain.util.ApiResponseStatus
import com.example.domain.util.networkCall

class CodeWarsDataSourceImpl : CodeWarsDataSource {
    override suspend fun getUser(
        apiService: CodeWarsInfoApiService,
        userName: String
    ): ApiResponseStatus<UserDTOResponse> =
        networkCall { apiService.getUser(userName = userName) }
}