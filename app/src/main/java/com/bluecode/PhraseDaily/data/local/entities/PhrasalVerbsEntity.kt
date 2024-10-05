package com.bluecode.PhraseDaily.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bluecode.PhraseDaily.domain.model.PhrasalVerb

@Entity(tableName = "phrasal_verbs")
data class PhrasalVerbsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val phrase_eng: String,
    val phrase_esp: String,
    val isCheck: Boolean = false
){
    fun toDomain(): PhrasalVerb {
        return PhrasalVerb(
            id = id,
            phrase_eng = phrase_eng,
            phrase_esp = phrase_esp,
            isCheck = isCheck
        )
    }
}
