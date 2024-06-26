package com.ex2.game_deals.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex2.game_data.DealSDK
import com.ex2.game_data.IDealSDK
import com.ex2.game_data.domain.models.Deal
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val dealSdk: IDealSDK = DealSDK
) : ViewModel() {

    private val _homeUiState =
        MutableStateFlow(HomeUiState(HomeUiState.PageState.LOADING, emptyList()))
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    init {
        _homeUiState.value = HomeUiState(HomeUiState.PageState.LOADING, emptyList())
    }

    fun fetchDeals() {
        viewModelScope.launch {
            val deals = dealSdk.fetchDeals(1)
            _homeUiState.update { HomeUiState(HomeUiState.PageState.LOADED, deals) }
        }
    }

    fun onDealClicked(deal: Deal) {
        // Handle deal click event
    }
}