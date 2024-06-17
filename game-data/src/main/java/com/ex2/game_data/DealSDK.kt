package com.ex2.game_data

import com.ex2.game_data.nw.api.DealsApi
import com.ex2.game_data.nw.provideHttpClientModule
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

object DealSDK : KoinComponent {

    private val dealsApi: DealsApi by inject()

    fun initialize() {
        startKoin {
            modules(provideHttpClientModule)
        }
    }

    fun fetchItems() {
        GlobalScope.launch {
            val list = dealsApi.fetchDeals()
            println("List = $list")
        }
    }
}