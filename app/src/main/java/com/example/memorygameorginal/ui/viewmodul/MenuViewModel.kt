package com.example.memorygameorginal.ui.viewmodul

import com.example.memorygameorginal.data.LevelEnum

interface MenuViewModel {
    fun openGameScreen(enum: LevelEnum)
    fun openInfoScreen()
}