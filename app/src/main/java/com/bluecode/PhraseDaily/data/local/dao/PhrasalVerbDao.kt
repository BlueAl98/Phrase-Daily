package com.bluecode.PhraseDaily.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bluecode.PhraseDaily.data.local.entities.PhrasalVerbsEntity

@Dao
interface PhrasalVerbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhrasalVerb(phrasalVerb: PhrasalVerbsEntity)

    @Query("SELECT * FROM phrasal_verbs")
    suspend fun getPhrasalVerbs(): List<PhrasalVerbsEntity>

}