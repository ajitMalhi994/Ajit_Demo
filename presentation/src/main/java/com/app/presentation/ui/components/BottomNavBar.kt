package com.app.presentation.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.presentation.R
import com.app.presentation.navigation.BottomNavScreen

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavScreen.WatchList,
        BottomNavScreen.Order,
        BottomNavScreen.Portfolio,
        BottomNavScreen.Funds,
        BottomNavScreen.Invest,
    )
    NavigationBar(
        containerColor = colorResource(id = R.color.bottomBar)
    ) {

        val currentRoute = currentBackStackEntryAsState(navController).value?.destination?.route
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = { Icon(screen.icon, contentDescription = screen.label) },
                label = { Text(screen.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.topBar),
                    unselectedIconColor = colorResource(id = R.color.textSecondary),
                    selectedTextColor = colorResource(id = R.color.topBar),
                    unselectedTextColor = colorResource(id = R.color.textSecondary),
                    indicatorColor = colorResource(id = R.color.transparent)
                )
            )
        }
    }
}

@Composable
fun currentBackStackEntryAsState(navController: NavController): State<NavBackStackEntry?> {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return rememberUpdatedState(navBackStackEntry)
}
