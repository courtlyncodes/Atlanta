package com.example.atlanta.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(
    val id: Int,
    val category: Category,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val avatar: Int,
    @StringRes val categoryName: Int
)