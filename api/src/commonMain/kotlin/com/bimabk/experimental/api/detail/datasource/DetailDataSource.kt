package com.bimabk.experimental.api.detail.datasource

import com.bimabk.experimental.api.core.utils.Constant.DETAIL_ENDPOINT
import com.bimabk.experimental.api.core.utils.Constant.DETAIL_PARAM
import com.bimabk.experimental.api.core.utils.Constant.URL
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

interface DetailDataSource {
    suspend fun getDetail(id: Int): HttpResponse
}

class DetailDataSourceImpl(
    private val httpClient: HttpClient
) : DetailDataSource {
    override suspend fun getDetail(id: Int): HttpResponse {
        return httpClient.get(URL.plus(DETAIL_ENDPOINT).plus(DETAIL_PARAM).plus(id.toString())) {
            contentType(ContentType.Application.Json)
        }
    }
}