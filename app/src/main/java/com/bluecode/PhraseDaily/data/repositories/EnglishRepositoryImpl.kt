package com.bluecode.PhraseDaily.data.repositories

import com.bluecode.PhraseDaily.data.model.PhrasalVerbDto
import com.bluecode.PhraseDaily.domain.model.PhrasalVerb
import com.bluecode.PhraseDaily.domain.repositories.EnglishRepository


class EnglishRepositoryImpl : EnglishRepository {

    override suspend fun getPhrasalVerbs(): List<PhrasalVerb> {

       val lista = listOf(
           PhrasalVerbDto(1,"get up","levantarse").toDomain())
        return  lista
    }
}