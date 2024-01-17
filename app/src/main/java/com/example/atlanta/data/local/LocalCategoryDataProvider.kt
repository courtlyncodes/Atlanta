package com.example.atlanta.data.local

import androidx.annotation.DrawableRes
import com.example.atlanta.R

data class Category(
    val name: String,
    @DrawableRes val icon: Int
)
object LocalCategoryDataProvider {

    val allCategories = listOf(
        Category(
            name = "Coffee Shops",
            icon = R.drawable.coffee_icon
        ),
        Category(
            name = "Dog Parks",
            icon = R.drawable.dog_icon
        ),
        Category(
            name = "Museums",
            icon = R.drawable.museum_icon
        ),
        Category(
            name = "Pizza Restaurants",
            icon = R.drawable.pizza_icon
        ),
        Category(
            name = "Shopping Centers",
            icon = R.drawable.mall_icon
        )
    )
}