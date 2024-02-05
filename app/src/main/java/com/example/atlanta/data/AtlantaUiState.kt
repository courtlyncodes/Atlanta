package com.example.atlanta.data

import com.example.atlanta.data.local.LocalRecommendationsDataProvider

data class AtlantaUiState(
    val category: Category = Category.COFFEE,
    val recommendation: Recommendation? = null,
    val recommendations: List<Recommendation> = listOf(),
    val isShowingRecommendations: Boolean = true
)