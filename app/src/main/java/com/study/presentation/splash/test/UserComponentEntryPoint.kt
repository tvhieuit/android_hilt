package com.study.presentation.splash.test

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@InstallIn(UserComponent::class)
@EntryPoint
interface UserComponentEntryPoint {
    fun userDataRepository(): UserDataRepository
}