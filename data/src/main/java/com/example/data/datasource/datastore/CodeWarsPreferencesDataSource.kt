package com.example.data.datasource.datastore

import kotlinx.coroutines.flow.Flow

interface CodeWarsPreferencesDataSource {
    suspend fun saveUserName(userName: String)
    suspend fun getUserName(): Flow<String>
}