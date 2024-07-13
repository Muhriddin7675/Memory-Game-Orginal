package com.example.memorygameorginal.domain.impl

import com.example.memorygameorginal.R
import com.example.memorygameorginal.app.data.CardData
import com.example.memorygameorginal.app.data.LevelEnum
import com.example.memorygameorginal.domain.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor() : AppRepository {

    private val list = ArrayList<CardData>()

    init {
        loadData()
    }

    private fun loadData() {
        list.add(CardData(1, R.drawable.image_1))
        list.add(CardData(2, R.drawable.image_2))
        list.add(CardData(3, R.drawable.image_3))
        list.add(CardData(4, R.drawable.image_4))
        list.add(CardData(5, R.drawable.image_5))
        list.add(CardData(6, R.drawable.image_6))
        list.add(CardData(7, R.drawable.image_7))
        list.add(CardData(8, R.drawable.image_8))
        list.add(CardData(9, R.drawable.image_9))
        list.add(CardData(10, R.drawable.image_10))
        list.add(CardData(11, R.drawable.image_11))
        list.add(CardData(12, R.drawable.image_12))
        list.add(CardData(13, R.drawable.image_13))
        list.add(CardData(14, R.drawable.image_14))
        list.add(CardData(15, R.drawable.image_15))
        list.add(CardData(16, R.drawable.image_16))
        list.add(CardData(17, R.drawable.image_17))
        list.add(CardData(18, R.drawable.image_18))
        list.add(CardData(19, R.drawable.image_19))
        list.add(CardData(20, R.drawable.image_20))
        list.add(CardData(21, R.drawable.image_21))
        list.add(CardData(22, R.drawable.image_22))
        list.add(CardData(23, R.drawable.image_23))
        list.add(CardData(24, R.drawable.image_24))
    }

    override fun getByLevel(enum: LevelEnum): Flow<List<CardData>> = flow {
        val count = (enum.horCount * enum.verCount) / 2
        list.shuffle()
        val resultLs = ArrayList<CardData>()
        resultLs.addAll(list.subList(0, count))
        resultLs.addAll(list.subList(0, count))
        resultLs.shuffle();
        emit(resultLs)
    }.flowOn(Dispatchers.IO)


}