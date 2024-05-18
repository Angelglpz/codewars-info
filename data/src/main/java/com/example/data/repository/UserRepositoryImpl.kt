package com.example.data.repository

import com.example.data.datasource.CodeWarsDataSourceImpl
import com.example.data.mapper.toModel
import com.example.domain.model.user.User
import com.example.domain.repository.UserRepository
import com.example.data.user.UserDTOResponse
import com.example.domain.util.ApiResponseStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSourceImpl: CodeWarsDataSourceImpl,
    private val ioDispatcher: CoroutineDispatcher
): UserRepository {
    override suspend fun getUser(userName: String): ApiResponseStatus<User> {
        return withContext(ioDispatcher) {
           dataSourceImpl.getUser(userName = userName)
        }
    }
}