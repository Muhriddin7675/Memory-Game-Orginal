package com.example.memorygameorginal.domain

import com.example.memorygameorginal.app.data.CardData
import com.example.memorygameorginal.app.data.LevelEnum
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getByLevel(enum: LevelEnum):Flow<List<CardData>>

}