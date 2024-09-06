package com.bimabk.experimental.api.signup.repository

import com.bimabk.experimental.api.signup.datasource.SignUpDataSource
import kotlinx.coroutines.CoroutineDispatcher

interface SignUpRepository {
}

class SignUpRepositoryImpl(
    private val dataSource: SignUpDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : SignUpRepository {

}