package com.ex2.game_data.repo

import com.ex2.game_data.DealSDK.fakeMode
import com.ex2.game_data.domain.DataFaker
import com.ex2.game_data.domain.models.Deal
import com.ex2.game_data.nw.api.DealsApi
import kotlin.math.roundToInt

internal class DealsRepo(private val dealsApi: DealsApi) {

    suspend fun fetchDeals(page: Int): List<Deal> {

        return if (fakeMode) {
            DataFaker.generateDeals(10)
        } else {
            val deals = dealsApi.fetchDeals()
            deals.map { d ->
                Deal(
                    title = d.title,
                    thumbnail = d.thumb,
                    releasedOn = d.releaseDate,
                    updatedOn = d.lastChange,
                    onSale = d.isOnSale ?: false,
                    dealRating = d.dealRating,
                    savings = d.savings.roundToInt(),
                    salePrice = d.salePrice,
                    normalPrice = d.normalPrice
                )
            }
        }
    }
}