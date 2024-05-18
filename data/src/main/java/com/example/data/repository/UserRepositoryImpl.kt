package com.example.data.repository

import com.example.data.datasource.CodeWarsDataSourceImpl
import com.example.domain.model.user.User
import com.example.domain.repository.IUserRepository
import com.example.domain.util.ApiResponseStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSourceImpl: CodeWarsDataSourceImpl,
    private val ioDispatcher: CoroutineDispatcher
): IUserRepository {
    override suspend fun getUser(userName: String): ApiResponseStatus<User> {
        return withContext(ioDispatcher) {
           dataSourceImpl.getUser(userName = userName)
        }
    }
}