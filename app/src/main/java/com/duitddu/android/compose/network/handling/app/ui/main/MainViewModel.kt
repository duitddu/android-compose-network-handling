package com.duitddu.android.compose.network.handling.app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duitddu.android.compose.network.handling.util.network.NetworkChecker
import com.duitddu.android.compose.network.handling.util.network.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkChecker: NetworkChecker
) : ViewModel() {
    private val _networkState = MutableSharedFlow<NetworkState>(replay = 1)
    val networkState: SharedFlow<NetworkState> = _networkState

    init {
        viewModelScope.launch {
            networkChecker.networkState.collectLatest {
                _networkState.emit(it)
            }
        }
    }

    fun onRetry() {
        // Do something.
    }
}