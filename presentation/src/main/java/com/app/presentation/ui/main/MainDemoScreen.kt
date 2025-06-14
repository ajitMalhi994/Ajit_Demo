package com.app.presentation.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.presentation.R
import com.app.presentation.navigation.BottomNavScreen
import com.app.presentation.ui.HoldingsScreen
import com.app.presentation.ui.components.BottomNavBar
import com.app.presentation.ui.components.HoldingsTopBar

@Composable
fun MainDemoScreen(title: String = stringResource(id = R.string.portfolio)) {

    val navController = rememberNavController()

    Scaffold(
        topBar = { HoldingsTopBar(title = title) },
        bottomBar = { BottomNavBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavScreen.Portfolio.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavScreen.Portfolio.route) {
                HoldingsScreen()
            }
            composable(BottomNavScreen.WatchList.route) {
                Text(stringResource(id = R.string.watch_screen), modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
            }
            composable(BottomNavScreen.Funds.route) {
                Text(stringResource(id = R.string.fund_screen), modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
            }
            composable(BottomNavScreen.Order.route) {
                Text(stringResource(id = R.string.order_screen), modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
            }
            composable(BottomNavScreen.Invest.route) {
                Text(stringResource(id = R.string.invest_screen), modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
            }
        }
    }
}