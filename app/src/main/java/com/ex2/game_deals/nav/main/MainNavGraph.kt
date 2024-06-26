package com.ex2.game_deals.nav.main

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ex2.game_deals.home.HomeScreen

fun NavGraphBuilder.mainTabs(navController: NavController) {
    navigation(startDestination = MainDestination.Home.route, route = "main") {
        composable(MainDestination.Home.route) {
            HomeScreen()
        }
        composable(MainDestination.Profile.route) {
            Text(text = MainDestination.Profile.label)
        }
        composable(MainDestination.Bookmarks.route) {
            Text(text = MainDestination.Bookmarks.label)
        }
    }
}