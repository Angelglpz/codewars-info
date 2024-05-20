package com.example.data.repository

import com.example.data.datasource.datastore.CodeWarsPreferencesDataSource
import com.example.domain.model.userdata.UserData
import com.example.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class UserPreferencesRepositoryImpl @Inject constructor(
    private val preferencesDataSource: CodeWarsPreferencesDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : UserPreferencesRepository {
    override suspend fun getUserName(): Flow<String> {
        return withContext(ioDispatcher) {
            preferencesDataSource.getUserName()
        }
    }
}