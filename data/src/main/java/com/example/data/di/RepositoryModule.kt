package com.example.data.di

import com.example.data.repository.UserPreferencesRepositoryImpl
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserPreferencesRepository
import com.example.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Binds
    @Singleton
    fun provideUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    fun provideUserPreferencesRepository(impl: UserPreferencesRepositoryImpl): UserPreferencesRepository
}