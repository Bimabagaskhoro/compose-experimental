package com.bimabk.experimental.api.home.datasource

import com.bimabk.experimental.api.core.utils.Constant.HOME_ENDPOINT
import com.bimabk.experimental.api.core.utils.Constant.URL
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

interface HomeDataSource {
    suspend fun getListFilm(): HttpResponse
}

class HomeDataSourceImpl(
    private val httpClient: HttpClient
) : HomeDataSource {
    override suspend fun getListFilm(): HttpResponse {
        return httpClient.get(URL.plus(HOME_ENDPOINT)) {
            contentType(ContentType.Application.Json)
        }
    }

}