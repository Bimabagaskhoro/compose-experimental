package com.bimabk.experimental.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bimabk.experimental.api.core.common.UiState
import com.bimabk.experimental.api.home.repository.HomeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val refreshFilm = MutableStateFlow(false)
    fun refreshFilm() = refreshFilm.update { !it }

    val film = refreshFilm.flatMapLatest {
        callbackFlow {
            send(UiState.Loading)
            try {
                send(UiState.Success(homeRepository.getListFilm()))
            } catch (e: Throwable) {
                send(UiState.Error(e))
            } finally {
                close()
            }
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, UiState.Init)
}