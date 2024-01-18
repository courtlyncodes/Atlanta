package com.example.atlanta.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(
    val category: com.example.atlanta.data.Category,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val avatar: Int,
)