package com.ex2.game_deals.common.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.ex2.game_deals.ui.theme.GamedealsTheme

@Composable
fun LoadingPage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LinearProgressIndicator()
    }
}

@Preview(device = Devices.PHONE)
@Preview(device = Devices.PHONE, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewLoadingPage() {
    GamedealsTheme {
        Surface {
            LoadingPage()
        }
    }
}