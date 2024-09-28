package com.bluecode.PhraseDaily.domain.usecases

import com.bluecode.PhraseDaily.domain.repositories.PhrasalVerbRepository
import javax.inject.Inject

class PhrasalVerbUseCase @Inject constructor(
    private val repository: PhrasalVerbRepository
) {

    suspend fun saveVerbsInDatabase() {
        repository.saveVerbsInDatabase()
    }

}