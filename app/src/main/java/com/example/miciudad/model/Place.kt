package com.example.miciudad.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    @StringRes val nameResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @StringRes val addressResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
