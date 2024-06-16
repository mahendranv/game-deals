package com.ex2.game_deals.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ex2.game_deals.nav.main.MainDestination
import com.ex2.game_deals.nav.main.mainTabs

val mainNavItems = listOf(
    MainDestination.Home,
    MainDestination.Bookmarks,
    MainDestination.Profile,
)

@Composable
fun AppMain() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        AppBottomNavBar(navController)
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "main",
            modifier = Modifier.padding(innerPadding)
        ) {
            mainTabs(navController)
        }
    }
}

@Composable
private fun AppBottomNavBar(navController: NavHostController) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        mainNavItems.forEach { dest ->
            val selected = currentDestination?.hierarchy?.any { it.route == dest.route } == true
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(dest.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = {
                    Text(text = dest.label)
                },
                icon = {
                    Icon(
                        imageVector = if (selected) dest.iconSelected else dest.icon,
                        contentDescription = null
                    )
                },
            )
        }
    }
}