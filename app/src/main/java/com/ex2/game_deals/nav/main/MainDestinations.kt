package com.ex2.game_deals.nav.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MainDestination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val iconSelected: ImageVector
) {

    data object Home : MainDestination(
        route = "home",
        label = "Home",
        icon = Icons.Outlined.Home,
        iconSelected = Icons.Filled.Home
    )

    data object Profile : MainDestination(
        route = "profile",
        label = "Profile",
        icon = Icons.Outlined.Person,
        iconSelected = Icons.Filled.Person
    )

    data object Bookmarks : MainDestination(
        route = "bookmarks",
        label = "Bookmarks",
        icon = Icons.Outlined.FavoriteBorder,
        iconSelected = Icons.Filled.Favorite
    )
}