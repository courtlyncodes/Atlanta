package com.example.atlanta.ui

import androidx.lifecycle.ViewModel
import com.example.atlanta.data.AtlantaUiState
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class AtlantaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AtlantaUiState())
    val uiState: StateFlow<AtlantaUiState> = _uiState.asStateFlow()

    fun updateRecommendation(selectedRecommendation: Recommendation) {
        _uiState.update { currentState ->
            currentState.copy(recommendation = selectedRecommendation)
        }
    }

    fun updateCategory(selectedCategory: Category) {
        _uiState.update { currentState ->
            currentState.copy(category = selectedCategory)
        }
    }
}

