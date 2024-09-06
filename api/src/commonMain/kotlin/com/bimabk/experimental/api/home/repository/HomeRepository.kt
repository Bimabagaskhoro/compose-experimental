package com.bimabk.experimental.api.home.repository

import com.bimabk.experimental.api.core.model.response.FilmResponse
import com.bimabk.experimental.api.home.datasource.HomeDataSource
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface HomeRepository {
    suspend fun getListFilm(): Flow<FilmResponse>
}

class HomeRepositoryImpl(
    private val dataSource: HomeDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : HomeRepository {
    override suspend fun getListFilm(): Flow<FilmResponse> {
        return flow {
            try {
                val response: HttpResponse = dataSource.getListFilm()
                if (response.status == HttpStatusCode.OK) {
                    emit(response.body<FilmResponse>())
                } else {
                    throw Throwable(response.status.value.toString())
                }
            } catch (e: Throwable) {
                throw e
            }
        }.flowOn(ioDispatcher)
    }
}