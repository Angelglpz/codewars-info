package com.example.data.di

import com.example.data.datasource.CodeWarsDataSource
import com.example.data.datasource.CodeWarsDataSourceImpl
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
}