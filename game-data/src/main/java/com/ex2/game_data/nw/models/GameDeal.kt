package com.ex2.game_data.nw.models

import com.ex2.game_data.nw.parser.IntBooleanSerializer
import com.ex2.game_data.nw.parser.LocalDateTimeSerializer
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Data class representing a game deal.
 */
@Serializable
internal data class GameDeal(

    /** Internal name of the game. */
    @SerialName("internalName") val internalName: String,

    /** Title of the game. */
    @SerialName("title") val title: String,

    /** Link to Metacritic page. */
    @SerialName("metacriticLink") val metacriticLink: String,

    /** Deal ID. */
    @SerialName("dealID") val dealID: String,

    /** Store ID. */
    @SerialName("storeID") val storeID: String?,

    /** Game ID. */
    @SerialName("gameID") val gameID: String,

    /** Sale price of the game. */
    @SerialName("salePrice") val salePrice: Float,

    /** Normal price of the game. */
    @SerialName("normalPrice") val normalPrice: Float,

    /** Flag indicating if the game is on sale. */
    @SerialName("isOnSale") @Serializable(with = IntBooleanSerializer::class) val isOnSale: Boolean?,

    /** Savings percentage. */
    @SerialName("savings") val savings: Float,

    /** Metacritic score. */
    @SerialName("metacriticScore") val metacriticScore: Int,

    /** Steam rating text. */
    @SerialName("steamRatingText") val steamRatingText: String,

    /** Steam rating percentage. */
    @SerialName("steamRatingPercent") val steamRatingPercent: String,

    /** Number of Steam ratings. */
    @SerialName("steamRatingCount") val steamRatingCount: Int,

    /** Steam App ID. */
    @SerialName("steamAppID") val steamAppID: String,

    /** Release date as LocalDateTime. */
    @SerialName("releaseDate") @Serializable(with = LocalDateTimeSerializer::class) val releaseDate: LocalDateTime,

    /** Last change date in epoch time. */
    @SerialName("lastChange") @Serializable(with = LocalDateTimeSerializer::class) val lastChange: LocalDateTime,

    /** Deal rating. */
    @SerialName("dealRating") val dealRating: String,

    /** Thumbnail URL. */
    @SerialName("thumb") val thumb: String
)