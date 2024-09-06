package com.bimabk.experimental.app.di

import com.bimabk.experimental.api.core.di.provideCommonModule
import com.bimabk.experimental.api.core.di.provideDataSourceModule
import com.bimabk.experimental.api.core.di.provideHttpClientModule
import com.bimabk.experimental.api.core.di.provideRepositoryModule

fun appModule() = listOf(
    provideHttpClientModule,
    provideCommonModule,
    provideDataSourceModule,
    provideRepositoryModule,
    provideFeatureModule
)