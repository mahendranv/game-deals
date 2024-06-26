package com.ex2.game_deals.nav.main

import androidx.compose.ui.graphics.vector.ImageVector
import com.ex2.game_deals.common.icons.AppIcons
import com.ex2.game_deals.common.icons.appicons.Bookmark
import com.ex2.game_deals.common.icons.appicons.BookmarkFilled
import com.ex2.game_deals.common.icons.appicons.CircleUserFilled
import com.ex2.game_deals.common.icons.appicons.CircleUser
import com.ex2.game_deals.common.icons.appicons.Home
import com.ex2.game_deals.common.icons.appicons.HomeFilled

sealed class MainDestination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val iconSelected: ImageVector
) {

    data object Home : MainDestination(
        route = "home",
        label = "Home",
        icon = AppIcons.Home,
        iconSelected = AppIcons.HomeFilled
    )

    data object Profile : MainDestination(
        route = "profile",
        label = "Profile",
        icon = AppIcons.CircleUser,
        iconSelected = AppIcons.CircleUserFilled
    )

    data object Bookmarks : MainDestination(
        route = "bookmarks",
        label = "Bookmarks",
        icon = AppIcons.Bookmark,
        iconSelected = AppIcons.BookmarkFilled
    )
}