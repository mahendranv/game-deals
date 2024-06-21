package com.ex2.game_data

import com.ex2.game_data.domain.models.Deal

public interface IDealSDK {

    public fun initialize()

    public fun enableFakeMode(enable: Boolean)

    public suspend fun fetchDeals(page: Int): List<Deal>

}