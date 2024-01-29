package com.example.atlanta.ui

import androidx.lifecycle.ViewModel
import com.example.atlanta.data.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class RecommendationViewModel : ViewModel() {
    private val _recommendationViewModel = MutableStateFlow<Recommendation?>(null)
    val recommendationViewModel: StateFlow<Recommendation?> = _recommendationViewModel.asStateFlow()

    fun updateRecommendation(selectedRecommendation: Recommendation) {
        _recommendationViewModel.value = selectedRecommendation
    }
}