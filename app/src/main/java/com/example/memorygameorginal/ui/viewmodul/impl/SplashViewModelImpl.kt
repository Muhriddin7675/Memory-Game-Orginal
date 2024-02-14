package com.example.memorygameorginal.ui.viewmodul.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorygameorginal.navigation.AppNavigator
import com.example.memorygameorginal.ui.screen.SplashScreenDirections
import com.example.memorygameorginal.ui.viewmodul.SplashViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val navigator: AppNavigator
): SplashViewModel,ViewModel() {
    override fun openMenuScreen() {
        viewModelScope.launch {
            navigator.navigateTo(SplashScreenDirections.actionSplashScreenToMenuScreen())
        }
    }
}