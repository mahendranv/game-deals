package com.ex2.game_deals

import android.app.Application
import com.ex2.game_data.DealSDK

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DealSDK.initialize()
    }
}