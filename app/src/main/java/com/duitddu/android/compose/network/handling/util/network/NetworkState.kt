package com.duitddu.android.compose.network.handling.util.network

sealed class NetworkState {
    object None: NetworkState()
    object Connected: NetworkState()
    object NotConnected: NetworkState()
}