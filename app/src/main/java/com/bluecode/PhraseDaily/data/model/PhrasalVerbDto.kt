package com.bluecode.PhraseDaily.data.model

import com.bluecode.PhraseDaily.data.local.entities.PhrasalVerbsEntity
import com.bluecode.PhraseDaily.domain.model.PhrasalVerb

data class PhrasalVerbDto(
    val PV: String,
    val TV: String,
) {

    fun toEntity(): PhrasalVerbsEntity {
        return PhrasalVerbsEntity(
            phrase_eng = PV,
            phrase_esp = TV
        )
    }
}