package com.ex2.game_data.domain.models

import kotlinx.datetime.LocalDateTime

data class Deal(
    val title: String,
    val thumbnail: String,
    val releasedOn: LocalDateTime,
    val updatedOn: LocalDateTime,

    val onSale: Boolean,
    val dealRating: String,

    val savings: Int,
    val salePrice: Float,
    val normalProce: Float,
)
