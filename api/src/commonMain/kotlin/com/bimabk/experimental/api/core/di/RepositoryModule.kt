package com.bimabk.experimental.api.core.di

import com.bimabk.experimental.api.detail.repository.DetailRepository
import com.bimabk.experimental.api.detail.repository.DetailRepositoryImpl
import com.bimabk.experimental.api.home.repository.HomeRepository
import com.bimabk.experimental.api.home.repository.HomeRepositoryImpl
import com.bimabk.experimental.api.signup.repository.SignUpRepository
import com.bimabk.experimental.api.signup.repository.SignUpRepositoryImpl
import org.koin.dsl.module

val provideRepositoryModule = module {
    single<DetailRepository> { DetailRepositoryImpl(get(), get()) }
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
    single<SignUpRepository> { SignUpRepositoryImpl(get(), get()) }
}