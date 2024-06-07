package com.example.miciudad.ui.ui


import androidx.lifecycle.ViewModel
import com.example.miciudad.model.Item
import com.example.miciudad.model.MyCityUiState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun updateCategory(item: Item) {
        _uiState.update { currentState ->
            currentState.copy(
                place = currentState.place,
                category = item.name
            )
        }
    }

    fun updatePlace(item: Item) {
        _uiState.update { currentState ->
            currentState.copy(
                place = item.name,
                category = currentState.category
            )
        }
    }
}
