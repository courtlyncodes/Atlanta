package com.example.atlanta.data

import androidx.compose.runtime.MutableState

enum class Category : MutableState<Category> {
    COFFEE, DOG_PARK, MUSEUM, PIZZA, SHOPPING_CENTER;

    override var value: Category
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun component1(): Category {
        TODO("Not yet implemented")
    }

    override fun component2(): (Category) -> Unit {
        TODO("Not yet implemented")
    }
}