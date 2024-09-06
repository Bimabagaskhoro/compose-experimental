package com.bimabk.experimental.api.core.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.qualifier.named
import org.koin.dsl.module

val provideCommonModule = module {
    single<CoroutineDispatcher>(named("IO")) { Dispatchers.IO }
    single<CoroutineDispatcher>(named("Main")) { Dispatchers.Main }
    single<CoroutineDispatcher>(named("Default")) { Dispatchers.Default }
}