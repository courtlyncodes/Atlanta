package com.example.atlanta.data


data class AtlantaUiState(
    val category: Category = Category.COFFEE,
    val recommendation: Recommendation? = null,
    val recommendations: List<Recommendation> = listOf(),
    val isShowingRecommendations: Boolean = true
)