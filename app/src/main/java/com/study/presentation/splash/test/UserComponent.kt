package com.study.presentation.splash.test

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Scope

/* Copyright 2020 Google LLC.
   SPDX-License-Identifier: Apache-2.0 */
// Annotation for scoping to UserComponent
@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class LoggedUserScope

// Types scoped to this component must be annotated with @LoggedUserScope
@LoggedUserScope
// Make UserComponent subcomponent of ApplicationComponent
@DefineComponent(parent = ApplicationComponent::class)
interface UserComponent {

    // Builder to create instances of UserComponent
    @DefineComponent.Builder
    interface Builder {
        fun setUser(@BindsInstance user: User): Builder
        fun build(): UserComponent
    }
}