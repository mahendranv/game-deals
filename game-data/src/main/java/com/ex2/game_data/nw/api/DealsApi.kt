package com.ex2.game_data.nw.api

import com.ex2.game_data.nw.models.DealInfoResponse
import com.ex2.game_data.nw.models.GameDeal

internal interface DealsApi {

    suspend fun fetchDeals(): List<GameDeal>

    suspend fun fetchDeal(dealId: String): DealInfoResponse?
}