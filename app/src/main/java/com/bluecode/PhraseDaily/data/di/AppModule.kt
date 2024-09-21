package com.bluecode.PhraseDaily.data.di

import com.bluecode.PhraseDaily.data.network.Api
import com.bluecode.PhraseDaily.data.repositories.EnglishRepositoryImpl
import com.bluecode.PhraseDaily.domain.repositories.EnglishRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/BlueAl98/jsonPhrases/refs/heads/main/") // Replace with your base URL
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()

    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }


    @Provides
    @Singleton
    fun provideEnglishRepository(api: Api): EnglishRepository {
        return EnglishRepositoryImpl(api)
    }





}