package dev.alexferreira.ui.model

import android.support.annotation.DrawableRes

data class MainMenuModel(
    @DrawableRes val image: Int,
    val title: String
)