package com.bluecode.PhraseDaily.domain.repositories

import com.bluecode.PhraseDaily.domain.model.PhrasalVerb
import kotlinx.coroutines.flow.Flow

interface EnglishRepository {

    suspend fun getPhrasalVerbs(): Flow<List<PhrasalVerb>>

}