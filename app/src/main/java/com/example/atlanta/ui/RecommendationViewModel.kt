package com.example.atlanta.ui

import androidx.lifecycle.ViewModel
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class RecommendationViewModel : ViewModel() {
    private val _recommendation = MutableStateFlow<Recommendation?>(null)
    val recommendation: StateFlow<Recommendation?> = _recommendation.asStateFlow()

    private val _category = MutableStateFlow(Category.COFFEE)
    val category: StateFlow<Category> = _category.asStateFlow()
//init block after declaring variable
//    init {
//
//    }
    fun updateRecommendation(selectedRecommendation: Recommendation) {
        _recommendation.value = selectedRecommendation
    }

    fun updateCategory(selectedCategory: Category){
        _category.value = selectedCategory
    }
}