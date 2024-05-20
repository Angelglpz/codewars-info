package com.example.data.di

import com.example.data.datasource.CodeWarsDataSource
import com.example.data.datasource.CodeWarsDataSourceImpl
import com.example.data.datasource.datastore.CodeWarsPreferencesDataSource
import com.example.data.datasource.datastore.CodeWarsPreferencesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {
    @Binds
    @Singleton
    fun provideCodeWarsDataSource(impl: CodeWarsDataSourceImpl): CodeWarsDataSource

    @Binds
    @Singleton
    fun providePreferencesDataSource(impl: CodeWarsPreferencesDataSourceImpl): CodeWarsPreferencesDataSource
}