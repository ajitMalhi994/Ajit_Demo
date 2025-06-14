package com.app.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreen(val route: String, val label: String, val icon: ImageVector) {
    data object WatchList : BottomNavScreen("watchlist", "Watchlist", Icons.Default.Menu)
    data object Order : BottomNavScreen("orders", "Orders", Icons.Default.ShoppingCart)
    data object Portfolio : BottomNavScreen("portfolio", "Portfolio", Icons.Default.AccountCircle)
    data object Funds : BottomNavScreen("funds", "Funds", Icons.Default.Star)
    data object Invest : BottomNavScreen("invest", "Invest", Icons.Default.PlayArrow)
}