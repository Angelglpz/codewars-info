package com.example.data.di

import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Binds
    @Singleton
    fun provideUserRepository(impl: UserRepositoryImpl): IUserRepository
}