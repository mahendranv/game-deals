package com.ex2.game_data.repo

import org.koin.dsl.module

internal val repoModule = module {

    single { DealsRepo(get()) }
}