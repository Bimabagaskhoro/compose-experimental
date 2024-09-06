package com.bimabk.experimental.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bimabk.experimental.api.core.common.UiState
import com.bimabk.experimental.api.detail.repository.DetailRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModel(
    private val detailViewModel: DetailRepository,
    private val id: Int
) : ViewModel() {
    private val refreshDetail = MutableStateFlow(false)
    fun refreshDetail() = refreshDetail.update { !it }

    val detail = refreshDetail.flatMapLatest {
        callbackFlow {
            send(UiState.Loading)
            try {
                send(UiState.Success(detailViewModel.getDetail(id)))
            } catch (e: Throwable) {
                send(UiState.Error(e))
            } finally {
                close()
            }
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, UiState.Init)
}