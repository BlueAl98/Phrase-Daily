package com.bluecode.PhraseDaily.domain.repositories

import com.bluecode.PhraseDaily.domain.model.PhrasalVerb

interface EnglishRepository {

    suspend fun getPhrasalVerbs(): List<PhrasalVerb>

}