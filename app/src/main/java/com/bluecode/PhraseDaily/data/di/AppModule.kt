package com.bluecode.PhraseDaily.data.di

import com.bluecode.PhraseDaily.data.repositories.EnglishRepositoryImpl
import com.bluecode.PhraseDaily.domain.repositories.EnglishRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEnglishRepository(): EnglishRepository {
        return EnglishRepositoryImpl()
    }
}