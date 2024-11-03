package com.example.practice_mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Building(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    val cost: Int,
    val upgradeCost: Int,
    @DrawableRes val imageRes: Int,
    val resourceProducedId: Int
)
