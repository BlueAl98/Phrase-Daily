package com.bluecode.PhraseDaily.domain.usecases

import com.bluecode.PhraseDaily.domain.model.PhrasalVerb
import com.bluecode.PhraseDaily.domain.repositories.PhrasalVerbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhrasalVerbUseCase @Inject constructor(
    private val repository: PhrasalVerbRepository
) {

    suspend fun saveVerbsInDatabase() {
        repository.saveVerbsInDatabase()
    }

    suspend fun getPhrasalVerbs(): Flow<List<PhrasalVerb>> {
        return repository.getPhrasalVerbs()
    }


}