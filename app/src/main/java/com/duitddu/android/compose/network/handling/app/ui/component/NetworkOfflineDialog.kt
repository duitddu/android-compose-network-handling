package com.duitddu.android.compose.network.handling.app.ui.component

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.duitddu.android.compose.network.handling.util.network.NetworkState

@Composable
fun NetworkOfflineDialog(
    networkState: NetworkState,
    onRetry: () -> Unit
) {
    if (networkState is NetworkState.NotConnected) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "인터넷이 연결되지 않았습니다.") },
            text = { Text(text = "인터넷 연결을 확인하신 후 재시도 버튼을 눌러주세요.") },
            confirmButton = {
                TextButton(onClick = onRetry) {
                    Text(text = "재시도")
                }
            }
        )
    }
}