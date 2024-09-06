package com.bimabk.experimental.api.detail.repository

import com.bimabk.experimental.api.core.model.response.DetailResponse
import com.bimabk.experimental.api.detail.datasource.DetailDataSource
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface DetailRepository {
    suspend fun getDetail(id: Int): Flow<DetailResponse>
}

class DetailRepositoryImpl(
    private val dataSource: DetailDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : DetailRepository {
    override suspend fun getDetail(id: Int): Flow<DetailResponse> {
        return flow {
            try {
                val response: HttpResponse = dataSource.getDetail(id)
                if (response.status == HttpStatusCode.OK) {
                    emit(response.body<DetailResponse>())
                } else {
                    throw Throwable(response.status.value.toString())
                }
            } catch (e: Throwable) {
                throw e
            }
        }.flowOn(ioDispatcher)
    }
}