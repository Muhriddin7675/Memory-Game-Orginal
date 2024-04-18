package com.example.memorygameorginal.ui.viewmodul.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorygameorginal.app.data.CardData
import com.example.memorygameorginal.app.data.LevelEnum
import com.example.memorygameorginal.domain.impl.AppRepositoryImpl
import com.example.memorygameorginal.navigation.AppNavigator
import com.example.memorygameorginal.ui.viewmodul.GameViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModelImpl @Inject constructor(
    private val navigator: AppNavigator,
    private val repositoryImpl: AppRepositoryImpl
) : ViewModel(), GameViewModel {
    override val cardFlow =
        MutableSharedFlow<List<CardData>>(replay = 1, onBufferOverflow = BufferOverflow.DROP_LATEST)
    override val closeAllViewsFlow =
        MutableSharedFlow<Unit>(replay = 1, onBufferOverflow = BufferOverflow.DROP_LATEST)

    override fun openCard() {
        viewModelScope.launch {
            delay(500)
            closeAllViewsFlow.emit(Unit)
        }
    }

    override fun closeGameScreen() {
        viewModelScope.launch {
            navigator.back()
        }
    }

    override fun loadCardByLevel(level: LevelEnum) {
        repositoryImpl.getByLevel(level)
            .onEach { cardFlow.emit(it) }
            .launchIn(viewModelScope)
    }


}