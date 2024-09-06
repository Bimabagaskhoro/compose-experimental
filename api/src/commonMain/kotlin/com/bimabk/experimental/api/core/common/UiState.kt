package com.bimabk.experimental.api.core.common

sealed interface UiState<out T> {
    data object Init : UiState<Nothing>
    data object Loading : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val error: Throwable? = null) : UiState<Nothing>
}

inline fun <T> UiState<T>.loading(action: () -> Unit): UiState<T> =
    apply {
        if (this is UiState.Loading) {
            action()
        }
    }

inline fun <T> UiState<T>.success(action: (data: T) -> Unit): UiState<T> =
    apply {
        if (this is UiState.Success) {
            action(data)
        }
    }

inline fun <T> UiState<T>.error(action: (error: Throwable?) -> Unit): UiState<T> =
    apply {
        if (this is UiState.Error) {
            action(error)
        }
    }