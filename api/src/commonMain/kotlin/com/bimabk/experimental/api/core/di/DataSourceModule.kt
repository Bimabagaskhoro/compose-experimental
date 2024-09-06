package com.bimabk.experimental.api.core.di

import com.bimabk.experimental.api.detail.datasource.DetailDataSource
import com.bimabk.experimental.api.detail.datasource.DetailDataSourceImpl
import com.bimabk.experimental.api.home.datasource.HomeDataSource
import com.bimabk.experimental.api.home.datasource.HomeDataSourceImpl
import com.bimabk.experimental.api.signup.datasource.SignUpDataSource
import com.bimabk.experimental.api.signup.datasource.SignUpDataSourceImpl
import org.koin.dsl.module

val provideDataSourceModule = module {
    single<DetailDataSource> { DetailDataSourceImpl(get()) }
    single<HomeDataSource> { HomeDataSourceImpl(get()) }
    single<SignUpDataSource> { SignUpDataSourceImpl(get()) }
}