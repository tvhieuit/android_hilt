package com.study.redux

import com.study.redux.impl.AppReducer
import com.study.redux.impl.AppState
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class AppStore @Inject constructor() {

    private val _state = BehaviorSubject.createDefault(AppState())

    val state: Observable<AppState> = _state.hide()

    private val reducer = AppReducer()

    fun dispatch(action: Action) {
        _state.value?.let { state ->
            _state.onNext(reducer.reduce(state, action)  )
        }
    }

}