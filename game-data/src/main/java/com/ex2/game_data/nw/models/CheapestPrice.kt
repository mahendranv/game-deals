package com.ex2.game_data.nw.models


import com.ex2.game_data.nw.parser.LocalDateTimeSerializer
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CheapestPrice(

    @SerialName("date") @Serializable(with = LocalDateTimeSerializer::class)
    val date: LocalDateTime,

    @SerialName("price")
    val price: Float
)