package com.example.memorygameorginal.ui.viewmodul.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorygameorginal.data.LevelEnum
import com.example.memorygameorginal.navigation.AppNavigator
import com.example.memorygameorginal.ui.screen.MenuScreenDirections
import com.example.memorygameorginal.ui.viewmodul.MenuViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModelImpl @Inject constructor(
    private val navigator: AppNavigator
):ViewModel(), MenuViewModel {
    override fun openGameScreen(enum: LevelEnum) {
        viewModelScope.launch {
            navigator.navigateTo(MenuScreenDirections.actionMenuScreenToGameScreen(enum))
        }
    }

    override fun openInfoScreen() {
        viewModelScope.launch {
            navigator.navigateTo(MenuScreenDirections.actionMenuScreenToInfoScreen())
        }
    }

}