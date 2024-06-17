package com.ex2.game_deals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ex2.game_deals.main.AppMain
import com.ex2.game_deals.ui.theme.GamedealsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamedealsTheme {
                AppMain()
            }
        }
    }

    override fun onResume() {
        super.onResume()
//        DealSDK.fetchItems()
    }
}