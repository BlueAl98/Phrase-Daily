package com.bluecode.PhraseDaily.data.network

import com.bluecode.PhraseDaily.data.model.PhrasalVerbDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface Api {

    @GET("myphrasal.json")
    suspend fun getPhrasalVerbs(): List<PhrasalVerbDto>

}