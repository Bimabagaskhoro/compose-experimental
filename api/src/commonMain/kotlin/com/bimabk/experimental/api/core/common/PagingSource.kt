package com.bimabk.experimental.api.core.common

import app.cash.paging.PagingSource
import app.cash.paging.PagingState

open class ResultPagingSource<T : Any>(private val pagingData: suspend (page: Int, pageSize: Int) -> UiState<List<T>>) :
    PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> =
        (params.key ?: 1).let { page ->
            try {
                pagingData(page, params.loadSize)
                    .run {
                        when (this) {
                            /* success */
                            is UiState.Success -> {
                                LoadResult.Page(
                                    data = data,
                                    /* no previous pagination int as page */
                                    prevKey = page.takeIf { it > 1 }?.dec(),
                                    /* no pagination if no results found else next page as +1 */
                                    nextKey = page.takeIf { data.size >= params.loadSize }?.inc()
                                )
                            }
                            /* error */
                            is Error -> LoadResult.Error(this)
                            else -> LoadResult.Error(IllegalStateException("$this type of [Result] is not allowed here"))
                        }
                    }
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
}