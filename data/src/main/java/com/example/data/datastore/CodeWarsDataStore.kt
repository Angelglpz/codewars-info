package com.example.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CodeWarsDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    internal fun <T> getValueFlow(
        key: Preferences.Key<T>,
        defaultValue: T
    ): Flow<T> {
        return dataStore.data.map {
            it[key] ?: defaultValue
        }
    }

    internal suspend fun <T> setValue(
        key: Preferences.Key<T>,
        value: T
    ) {
        dataStore.edit {
            it[key] = value
        }
    }
}