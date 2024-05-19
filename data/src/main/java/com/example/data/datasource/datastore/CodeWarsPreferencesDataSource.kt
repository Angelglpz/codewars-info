package com.example.data.datasource.datastore

interface CodeWarsPreferencesDataSource {
    suspend fun saveUserName(userName: String)
    fun getUserName(userName: String)
}