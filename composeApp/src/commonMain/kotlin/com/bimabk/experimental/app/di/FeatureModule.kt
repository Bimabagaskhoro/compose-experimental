package com.bimabk.experimental.app.di

import com.bimabk.experimental.detail.viewmodel.DetailViewModel
import com.bimabk.experimental.home.viewmodel.HomeViewModel
import org.koin.dsl.module

val provideFeatureModule = module {
    factory { HomeViewModel(get()) }
    factory { (id: Int) -> DetailViewModel(get(), id) }
}