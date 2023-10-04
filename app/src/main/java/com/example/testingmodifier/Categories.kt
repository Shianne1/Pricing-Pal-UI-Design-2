package com.example.testingmodifier

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Categories (
    @StringRes val categoryID: Int,
    @DrawableRes val imagesID: Int
)