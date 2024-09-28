package com.bluecode.PhraseDaily.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluecode.PhraseDaily.domain.usecases.PhrasalVerbUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: PhrasalVerbUseCase
): ViewModel() {

    fun saveVerbsInDatabase() {
        viewModelScope.launch {
            useCase.saveVerbsInDatabase()
        }
    }

}