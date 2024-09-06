package com.bimabk.experimental.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.bimabk.experimental.api.core.common.error
import com.bimabk.experimental.api.core.common.loading
import com.bimabk.experimental.api.core.common.success
import com.bimabk.experimental.component.BaseScreen
import com.bimabk.experimental.home.viewmodel.HomeViewModel
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinInject()
) {
    val list by viewModel.film.collectAsState()
    BaseScreen(
        title = "",
        navigateBack = {}
    ) {
        list
            .loading { }
            .success {
                HomeSection()
            }
            .error { }
    }
}

@Composable
fun HomeSection() {

}