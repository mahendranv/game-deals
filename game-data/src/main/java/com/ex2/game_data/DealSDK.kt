package com.ex2.game_data

import com.ex2.game_data.domain.models.Deal
import com.ex2.game_data.nw.networkModule
import com.ex2.game_data.repo.DealsRepo
import com.ex2.game_data.repo.repoModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

public object DealSDK : IDealSDK, KoinComponent {

    private val dealsRepo: DealsRepo by inject()

    internal var fakeMode: Boolean = false
        private set

    override fun initialize() {
        startKoin {
            modules(networkModule, repoModule)
        }
    }

    override fun enableFakeMode(enable: Boolean) {
        fakeMode = enable
    }

    override suspend fun fetchDeals(page: Int): List<Deal> {
        return dealsRepo.fetchDeals(page)
    }
}