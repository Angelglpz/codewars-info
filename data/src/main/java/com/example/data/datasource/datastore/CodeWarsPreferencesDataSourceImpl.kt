package com.example.data.datasource.datastore

import com.example.data.datastore.CodeWarsDataStore
import com.example.data.datastore.util.KEY_USERNAME
import javax.inject.Inject

class CodeWarsPreferencesDataSourceImpl @Inject constructor(
    private val codeWarsDataStore: CodeWarsDataStore
) : CodeWarsPreferencesDataSource {
    override suspend fun saveUserName(userName: String) {
        codeWarsDataStore.setValue(key = KEY_USERNAME, value = userName)
    }

    override fun getUserName(userName: String) {
        TODO("Not yet implemented")
    }
}