package com.bluecode.PhraseDaily.data.repositories

import com.bluecode.PhraseDaily.data.local.dao.PhrasalVerbDao
import com.bluecode.PhraseDaily.data.network.Api
import com.bluecode.PhraseDaily.domain.model.PhrasalVerb
import com.bluecode.PhraseDaily.domain.repositories.PhrasalVerbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhrasalVerbRepositoryImpl @Inject constructor(
    private val api: Api,
    private val phrasalVerbDao: PhrasalVerbDao
) : PhrasalVerbRepository {

    override suspend fun getPhrasalVerbs(): Flow<List<PhrasalVerb>> {
        return flow {
            val phrasalVerbsEntity = phrasalVerbDao.getPhrasalVerbs().map {
                it.toDomain()
            }
            emit(phrasalVerbsEntity)
        }
    }

    override suspend fun saveVerbsInDatabase() {
        val phrasalVerbs = api.getPhrasalVerbs()

        for (phrasalVerb in phrasalVerbs) {
            val entity = phrasalVerb.toEntity()
            phrasalVerbDao.insertPhrasalVerb(entity)
        }

    }

    override suspend fun getPhrsalVerByCheck(isCheck: Boolean): Flow<List<PhrasalVerb>> {
        return flow {
            val phrasalVerbsEntity = phrasalVerbDao.getPhrasalVerbByCheck(isCheck).map {
                it.toDomain()
            }
            emit(phrasalVerbsEntity)
        }
    }
}