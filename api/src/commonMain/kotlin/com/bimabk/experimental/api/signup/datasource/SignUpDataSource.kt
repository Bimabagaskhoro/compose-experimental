package com.bimabk.experimental.api.signup.datasource

import io.ktor.client.HttpClient

interface SignUpDataSource {
}

class SignUpDataSourceImpl(
    private val httpClient: HttpClient
) : SignUpDataSource {

}