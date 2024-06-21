package com.ex2.game_data.nw.api

import com.ex2.game_data.nw.models.DealInfoResponse
import com.ex2.game_data.nw.models.GameDeal
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode

internal class DealsApiImpl(
    private val httpClient: HttpClient
) : DealsApi {

    override suspend fun fetchDeals(): List<GameDeal> {
        val response =
            httpClient.get("https://www.cheapshark.com/api/1.0/deals?storeID=1&upperPrice=15")
        return if (response.status == HttpStatusCode.OK) {
            response.body()
        } else {
            emptyList()
        }
    }

    override suspend fun fetchDeal(dealId: String): DealInfoResponse? {
        val response = httpClient.get("https://www.cheapshark.com/api/1.0/deals?id=$dealId")
        return if (response.status == HttpStatusCode.OK) {
            response.body()
        } else {
            null
        }
    }
}