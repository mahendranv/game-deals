package com.ex2.game_deals.common.icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.ex2.game_deals.common.icons.appicons.Bookmark
import com.ex2.game_deals.common.icons.appicons.BookmarkFilled
import com.ex2.game_deals.common.icons.appicons.CircleUser
import com.ex2.game_deals.common.icons.appicons.Dice
import com.ex2.game_deals.common.icons.appicons.Home
import com.ex2.game_deals.common.icons.appicons.HomeFilled
import com.ex2.game_deals.common.icons.appicons.Loading
import com.ex2.game_deals.common.icons.appicons.CircleUserFilled
import kotlin.collections.List as ____KtList

public object AppIcons

private var __AllIcons: ____KtList<ImageVector>? = null

public val AppIcons.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Home, CircleUser, HomeFilled, Loading, CircleUserFilled, Dice, Bookmark,
        BookmarkFilled)
    return __AllIcons!!
  }
