package com.example.data.datasource.datastore

import com.example.data.datastore.CodeWarsDataStore
import com.example.data.datastore.util.KEY_USERNAME
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class CodeWarsPreferencesDataSourceImpl @Inject constructor(
    private val codeWarsDataStore: CodeWarsDataStore
) : CodeWarsPreferencesDataSource {
    override suspend fun saveUserName(userName: String) {
        codeWarsDataStore.setValue(key = KEY_USERNAME, value = userName)
    }

    override suspend fun getUserName(): Flow<String> {
        return codeWarsDataStore.getValueFlow(
            key = KEY_USERNAME,
            defaultValue = ""
        )
    }
}