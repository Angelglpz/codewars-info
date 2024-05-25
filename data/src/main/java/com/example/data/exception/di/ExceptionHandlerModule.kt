package com.example.data.exception.di

import com.example.data.exception.ExceptionHandlerInterface
import com.example.data.exception.genericexception.GenericExceptionHandler
import com.example.data.exception.httpexception.HttpExceptionHandler
import dagger.Binds

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.Multibinds
import retrofit2.HttpException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExceptionHandlerModule {



    @Provides
    fun provideExceptionHandlerMap(): Map<Class<out Exception>, ExceptionHandlerInterface> =
        mapOf(
            HttpException::class.java to HttpExceptionHandler(),
            Exception::class.java to GenericExceptionHandler()
        )
}