package com.example.practice_mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Resource(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
    val goldValue: Int
)
