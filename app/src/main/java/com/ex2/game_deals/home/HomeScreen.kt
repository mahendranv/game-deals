package com.ex2.game_deals.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ex2.game_data.domain.models.Deal
import com.ex2.game_deals.common.ui.DealItemUi
import com.ex2.game_deals.common.ui.LoadingPage

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.homeUiState.collectAsState()
    HomeScreenRoot(uiState)

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchDeals()
    }
}

@Composable
fun HomeScreenRoot(uiState: HomeUiState) {
    Surface {
        when (uiState.state) {
            HomeUiState.PageState.LOADING -> LoadingPage()
            HomeUiState.PageState.LOADED -> HomeContent(uiState.deals)
        }
    }
}

@Composable
fun HomeContent(deals: List<Deal>) {
    LazyColumn {
        items(deals) { deal ->
            DealItemUi(deal = deal)
        }
    }
}