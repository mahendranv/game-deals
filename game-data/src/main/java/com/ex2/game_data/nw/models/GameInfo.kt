package com.ex2.game_data.nw.models

import com.ex2.game_data.nw.parser.LocalDateTimeSerializer
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameInfo(
    @SerialName("gameID")
    val gameID: String,
    @SerialName("metacriticLink")
    val metacriticLink: String,
    @SerialName("metacriticScore")
    val metacriticScore: String,
    @SerialName("name")
    val name: String,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("releaseDate") @Serializable(with = LocalDateTimeSerializer::class) val releaseDate: LocalDateTime,
    @SerialName("retailPrice")
    val retailPrice: Float,
    @SerialName("salePrice")
    val salePrice: Float,
    @SerialName("steamAppID")
    val steamAppID: String,
    @SerialName("steamRatingCount")
    val steamRatingCount: Int,
    @SerialName("steamRatingPercent")
    val steamRatingPercent: Int,
    @SerialName("steamRatingText")
    val steamRatingText: String,
    @SerialName("steamworks")
    val steamworks: String,
    @SerialName("storeID")
    val storeID: String,
    @SerialName("thumb")
    val thumb: String
)