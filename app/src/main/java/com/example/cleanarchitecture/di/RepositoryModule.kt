package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.provider.UsersProvider
import com.example.cleanarchitecture.repository.UsersRepository
import com.example.cleanarchitecture.repository.UsersRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providerUsersRepository(provider: UsersProvider): UsersRepository =
        UsersRepositoryImp(provider)

}