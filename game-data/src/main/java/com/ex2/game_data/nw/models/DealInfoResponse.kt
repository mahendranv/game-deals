package com.ex2.game_data.nw.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DealInfoResponse(
    @SerialName("cheaperStores")
    val cheaperStores: List<CheaperStore>,
    @SerialName("cheapestPrice")
    val cheapestPrice: CheapestPrice,
    @SerialName("gameInfo")
    val gameInfo: GameInfo
)