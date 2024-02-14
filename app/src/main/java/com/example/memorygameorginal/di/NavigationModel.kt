package com.example.memorygameorginal.di

import com.example.memorygameorginal.navigation.AppNavigationDispatcher
import com.example.memorygameorginal.navigation.AppNavigationHandler
import com.example.memorygameorginal.navigation.AppNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModel {
    @Binds
    fun bindAppNavigation(impl: AppNavigationDispatcher): AppNavigator

    @Binds
    fun bindAppNavigationHandler(impl: AppNavigationDispatcher): AppNavigationHandler

}