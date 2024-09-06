package com.bimabk.experimental.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.bimabk.experimental.app.di.appModule
import com.bimabk.experimental.app.navigation.AppNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() = MaterialTheme {
    KoinApplication(application = {
        modules(appModule())
    }) {
        val navController = rememberNavController()
        AppNavGraph(navController = navController)
    }
}