package com.bluecode.PhraseDaily.domain.repositories

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun saveDate(date: String)
    suspend fun getDate(): Flow<String?>
}