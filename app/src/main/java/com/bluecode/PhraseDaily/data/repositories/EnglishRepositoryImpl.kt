package com.bluecode.PhraseDaily.data.repositories

import android.util.Log
import com.bluecode.PhraseDaily.data.model.PhrasalVerbDto
import com.bluecode.PhraseDaily.data.network.Api
import com.bluecode.PhraseDaily.domain.model.PhrasalVerb
import com.bluecode.PhraseDaily.domain.repositories.EnglishRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class EnglishRepositoryImpl @Inject constructor(
    private val api: Api
) : EnglishRepository {

    override suspend fun getPhrasalVerbs(): Flow<List<PhrasalVerb>> {
        return flow {

            // Transform the DTO into domain model
            val domainPhrasalVerbs = api.getPhrasalVerbs().map { dto -> dto.toDomain() }
            emit(domainPhrasalVerbs)
        }
    }
}