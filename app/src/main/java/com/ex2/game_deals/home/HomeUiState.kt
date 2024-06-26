package com.ex2.game_deals.home

import com.ex2.game_data.domain.models.Deal

data class HomeUiState(
    val state: PageState,
    val deals: List<Deal>
) {
    enum class PageState {
        LOADING,
        LOADED
    }
}
