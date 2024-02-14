package com.example.memorygameorginal.di

import com.example.memorygameorginal.domain.AppRepository
import com.example.memorygameorginal.domain.impl.AppRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
interface AppRepositoryModel {
    @Binds
    fun getRepository(impl: AppRepositoryImpl): AppRepository
}