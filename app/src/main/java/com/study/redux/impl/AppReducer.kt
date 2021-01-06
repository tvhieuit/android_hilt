package com.study.redux.impl

import com.study.redux.Action
import com.study.redux.Reducer

class AppReducer : Reducer<AppState> {

    private val reducers = listOf<Reducer<AppState>>()

    override fun reduce(state: AppState, action: Action): AppState {
        return reducers.fold(state) { newState, reducer ->
            reducer.reduce(newState, action)
        }
    }
}