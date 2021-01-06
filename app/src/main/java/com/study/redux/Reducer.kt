package com.study.redux

interface Reducer<T : State> {

    fun reduce(state: T, action: Action): T
}
