package com.bluecode.PhraseDaily.domain.repositories

import com.bluecode.PhraseDaily.domain.model.PhrasalVerb
import kotlinx.coroutines.flow.Flow

interface PhrasalVerbRepository {

    suspend fun getPhrasalVerbs(): Flow<List<PhrasalVerb>>

    suspend fun saveVerbsInDatabase()

    suspend fun getPhrsalVerByCheck(isCheck: Boolean): Flow<List<PhrasalVerb>>
}