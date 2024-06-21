package com.ex2.game_data.repo

import com.ex2.game_data.DealSDK.fakeMode
import com.ex2.game_data.domain.DataFaker
import com.ex2.game_data.domain.models.Deal
import com.ex2.game_data.nw.api.DealsApi

internal class DealsRepo(private val dealsApi: DealsApi) {

    suspend fun fetchDeals(page: Int): List<Deal> {

        return if (fakeMode) {
            DataFaker.generateDeals(10)
        } else {
            val deals = dealsApi.fetchDeals()
            emptyList()
        }
    }
}