package com.example.app_30_dias.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Receta(
    @StringRes val day: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
