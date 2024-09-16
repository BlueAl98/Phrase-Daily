package com.bluecode.PhraseDaily.data.model

import com.bluecode.PhraseDaily.domain.model.PhrasalVerb

data class PhrasalVerbDto (
    val id: Int,
    val phrase_eng: String,
    val phrase_esp: String,
) {
    fun toDomain(): PhrasalVerb {
        return PhrasalVerb(
            id = id,
            phrase_eng = phrase_eng,
            phrase_esp = phrase_esp
        )
    }
}