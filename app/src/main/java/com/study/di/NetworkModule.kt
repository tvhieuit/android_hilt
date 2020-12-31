package com.study.di

import com.study.network.NetworkTest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    @Provides
    fun network() : NetworkTest = NetworkTest()
}