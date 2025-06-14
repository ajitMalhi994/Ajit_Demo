package com.app.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.app.presentation.R
import com.app.presentation.ui.enums.TabType

@Composable
fun ToggleTabs(
    selectedTab: TabType,
    onTabSelected: (TabType) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TabButton(
                title = stringResource(id = R.string.positions_L),
                isSelected = selectedTab == TabType.POSITIONS,
                onClick = { onTabSelected(TabType.POSITIONS) }
            )
            TabButton(
                title = stringResource(id = R.string.holdings_L),
                isSelected = selectedTab == TabType.HOLDINGS,
                onClick = { onTabSelected(TabType.HOLDINGS) }
            )
        }
        Box(
            modifier = Modifier
                .height(0.5.dp)
                .fillMaxWidth()
                .background(Color.DarkGray)
        )
    }
}
