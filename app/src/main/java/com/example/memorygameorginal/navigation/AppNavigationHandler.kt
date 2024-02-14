package com.example.memorygameorginal.navigation

import kotlinx.coroutines.flow.Flow


interface AppNavigationHandler {

    val buffer : Flow<AppNavigation>
}