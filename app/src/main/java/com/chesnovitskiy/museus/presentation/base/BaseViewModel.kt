package com.chesnovitskiy.museus.presentation.base

import androidx.annotation.UiThread
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<T : BaseViewState>(initialState: T) : ViewModel() {

    protected val _viewStateFlow: MutableStateFlow<T> = MutableStateFlow(initialState)
    val viewStateFlow: StateFlow<T>
        get() = _viewStateFlow

    protected val currentState: T
        get() = _viewStateFlow.value

    @UiThread
    protected inline fun updateState(update: (currentState: T) -> T) {
        val updatedState: T = update(currentState)
        if (updatedState != currentState) {
            _viewStateFlow.value = updatedState
        }
    }
}

interface BaseViewState