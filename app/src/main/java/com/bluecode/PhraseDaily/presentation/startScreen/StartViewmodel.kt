package com.bluecode.PhraseDaily.presentation.startScreen

import androidx.lifecycle.ViewModel
import com.bluecode.PhraseDaily.domain.repositories.PhrasalVerbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewmodel @Inject constructor(
    private val phraseVerbUseCase: PhrasalVerbRepository
): ViewModel() {


}