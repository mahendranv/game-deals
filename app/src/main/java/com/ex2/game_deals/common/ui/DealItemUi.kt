package com.ex2.game_deals.common.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ex2.game_data.DealSDK
import com.ex2.game_data.DealSDK.fetchDeals
import com.ex2.game_data.domain.models.Deal
import com.ex2.game_deals.ui.theme.GamedealsTheme
import kotlinx.coroutines.runBlocking

@Composable
fun DealItemUi(modifier: Modifier = Modifier, deal: Deal) {
    Row(modifier) {
        OnlineImage(
            url = deal.thumbnail,
            modifier = Modifier
                .size(100.dp)
                .border(width = 1.dp, color = Color.Red, shape = RoundedCornerShape(8.dp))
                .padding(24.dp)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column {
            Text(text = deal.title, style = MaterialTheme.typography.titleMedium)
            Text(text = deal.salePrice.toString(), style = MaterialTheme.typography.bodySmall)
        }
    }
}

fun getItems(): List<Deal> {
    DealSDK.apply {
        initialize()
        enableFakeMode(true)
    }
    return runBlocking {
        fetchDeals(1)
    }
}

@Preview(device = Devices.NEXUS_6)
@Composable
private fun DealItemUiPreview() {
    GamedealsTheme {
        Surface {
            LazyColumn(
                Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(getItems()) { deal ->
                    DealItemUi(deal = deal, modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}