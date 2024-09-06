package com.bimabk.experimental.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(
    title: String,
    navigateBack: () -> Unit,
    showIconBack: Boolean = true,
    content: @Composable (PaddingValues) -> Unit
) {
    val scrollBehavior = pinnedScrollBehavior(rememberTopAppBarState())

    MaterialTheme {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = title,
                            style = typography.titleLarge,
                            color = colorScheme.onSurface,
                            maxLines = 1,
                            overflow = Ellipsis
                        )
                    },
                    navigationIcon = {
                        if (showIconBack) {
                            IconButton(onClick = navigateBack) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    tint = colorScheme.primary,
                                    contentDescription = null
                                )
                            }
                        }
                    },
                    actions = {},
                    scrollBehavior = scrollBehavior
                )
            }
        ) { content(it) }
    }
}