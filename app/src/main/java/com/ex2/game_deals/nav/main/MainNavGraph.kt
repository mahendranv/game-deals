package com.ex2.game_deals.nav.main

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.mainTabs(navController: NavController) {
    navigation(startDestination = MainDestination.Home.route, route = "main") {
        composable(MainDestination.Home.route) {
            Text(text = MainDestination.Home.label)
        }
        composable(MainDestination.Profile.route) {
            Text(text = MainDestination.Profile.label)
        }
        composable(MainDestination.Bookmarks.route) {
            Text(text = MainDestination.Bookmarks.label)
        }
    }
}