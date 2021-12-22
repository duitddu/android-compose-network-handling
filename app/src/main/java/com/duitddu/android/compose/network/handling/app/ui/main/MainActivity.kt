package com.duitddu.android.compose.network.handling.app.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.duitddu.android.compose.network.handling.app.ui.component.NetworkOfflineDialog
import com.duitddu.android.compose.network.handling.app.ui.theme.ComposeNetworkHandlingTheme
import com.duitddu.android.compose.network.handling.util.network.NetworkState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNetworkHandlingTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainPage(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainPage(viewModel: MainViewModel) {
    val networkState by viewModel.networkState.collectAsState(initial = NetworkState.None)

    NetworkOfflineDialog(networkState = networkState) {
        viewModel.onRetry()
    }
}
