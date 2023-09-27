package com.example.a20200112_cuadricula.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val courseName: Int,
    val numberCourses: Int,
    @DrawableRes val image: Int
)
