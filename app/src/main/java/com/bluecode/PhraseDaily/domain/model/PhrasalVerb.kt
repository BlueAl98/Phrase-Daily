package com.bluecode.PhraseDaily.domain.model

data class PhrasalVerb(
    val id: Int = 0,
    val phrase_eng: String,
    val phrase_esp: String,
    val isCheck: Boolean
)
