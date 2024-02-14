package com.example.memorygameorginal.ui.viewmodul

import com.example.memorygameorginal.data.CardData
import com.example.memorygameorginal.data.LevelEnum
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface GameViewModel {

 val cardFlow: Flow<List<CardData>>
 val closeAllViewsFlow :Flow<Unit>

 fun loadCardByLevel(level: LevelEnum)
}