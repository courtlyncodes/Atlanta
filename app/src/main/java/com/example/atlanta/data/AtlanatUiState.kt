package com.example.atlanta.data

import com.example.atlanta.data.local.LocalRecommendationsDataProvider

data class AtlantaUiState(
//    val name: Int = 0,
//    val avatar: Int = 0,
//    val description: Int = 0,
    val category: Category = Category.COFFEE,
    val recommendation: Recommendation = LocalRecommendationsDataProvider.allRecommendations.first { it.category == category },
    val recommendations: List<Recommendation> = listOf()
)