package com.bluecode.PhraseDaily.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.bluecode.PhraseDaily.domain.repositories.DataStoreRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreSourceRepoImp @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreRepository {

    companion object {
        val DATE_KEY = stringPreferencesKey("date_key")
    }

    override suspend fun saveDate(date: String) {
        dataStore.edit { preferences ->
            // Eliminar la clave existente (si existe)
            preferences.remove(DATE_KEY)

            // Guardar el nuevo valor si no está vacío
            if (date.isNotEmpty()) {
                preferences[DATE_KEY] = date
            }
        }
    }

    override suspend fun getDate(): Flow<String?> {
        return dataStore.data.map { preferences ->
            preferences[DATE_KEY]
        }
    }


}