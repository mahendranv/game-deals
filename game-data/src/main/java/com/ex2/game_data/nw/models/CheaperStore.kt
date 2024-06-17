package com.ex2.game_data.nw.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CheaperStore(
    @SerialName("dealID")
    val dealID: String,
    @SerialName("retailPrice")
    val retailPrice: Float,
    @SerialName("salePrice")
    val salePrice: Float,
    @SerialName("storeID")
    val storeID: String
)