package com.example.data.repository

import com.example.data.datasource.datastore.CodeWarsPreferencesDataSource
import com.example.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class UserPreferencesRepositoryImpl @Inject constructor(
    private val preferencesDataSource: CodeWarsPreferencesDataSource
) : UserPreferencesRepository {
    override fun getUserName(): Flow<String> {
        return preferencesDataSource.getUserName()
    }

    override suspend fun saveUserName(userName: String) {
        preferencesDataSource.saveUserName(userName)
    }
}