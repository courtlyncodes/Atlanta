package com.example.atlanta.ui

import androidx.lifecycle.ViewModel
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.RecommendationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class RecommendationViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RecommendationUiState(currentRecommendation = Recommendation(
        1, Category.COFFEE, 0, 0, 0, 0)))
    val uiState: StateFlow<RecommendationUiState> = _uiState.asStateFlow()

//    fun setName(recommendation: Recommendation) {
//        _uiState.update { currentState ->
//            currentState.copy(
//                name = recommendation.name
//            )
//        }
//    }
//
//    fun setAvatar(recommendation: Recommendation) {
//        _uiState.update { currentState ->
//            currentState.copy(
//                avatar = recommendation.avatar
//            )
//        }
//    }
//
//    fun setDescription(recommendation: Recommendation) {
//        _uiState.update { currentState ->
//            currentState.copy(
//                description =  recommendation.description
//            )
//        }
//    }

    fun setSelectedRecommendation(recommendation: Recommendation) {
        _uiState.value = _uiState.value.copy(currentRecommendation = recommendation)
    }
}