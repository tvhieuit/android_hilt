package com.study.presentation.splash.test

import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/* Copyright 2020 Google LLC.
   SPDX-License-Identifier: Apache-2.0 */
@Singleton
class UserManager @Inject constructor(
    // Since UserManager will be in charge of managing the UserComponent's
    // lifecycle, it needs to know how to create instances of it. We use the
    // provider (i.e. factory) Dagger generates for us to create instances of UserComponent.
    private val userComponentProvider: Provider<UserComponent.Builder>
) {

    /**
     *  UserComponent is specific to a logged in user. Holds an instance of
     *  UserComponent. This determines if the user is logged in or not, when the
     *  user logs in, a new Component will be created.
     *  When the user logs out, this will be null.
     */
    var userComponent: UserComponent? = null

    private fun userLoggedIn(userId: String) {
        // When the user logs in, we create a new instance of UserComponent
        val user = User(userId)
        userComponent = userComponentProvider.get().setUser(user).build()
    }

    private fun logout() {
        // When the user logs out, we remove the instance of UserComponent from memory
        userComponent = null
    }
}