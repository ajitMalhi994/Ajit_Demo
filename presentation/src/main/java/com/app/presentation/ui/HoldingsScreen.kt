package com.app.presentation.ui

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.app.presentation.R
import com.app.presentation.ui.components.HoldingRow
import com.app.presentation.ui.components.Loader
import com.app.presentation.ui.components.PortfolioSummary
import com.app.presentation.ui.components.ToggleTabs
import com.app.presentation.ui.components.TotalPnL
import com.app.presentation.ui.enums.TabType
import com.app.presentation.ui.viewmodels.CalculatePnlViewModel
import com.app.presentation.ui.viewmodels.MainViewModel
import com.domain.usecase.CalculateCurrentValueUseCase
import com.domain.usecase.CalculateSinglePnlUseCase
import com.domain.usecase.CalculateTodaysPnlUseCase
import com.domain.usecase.CalculateTotalInvestmentUseCase
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HoldingsScreen(
    mainViewModel: MainViewModel = koinViewModel()
) {
    val context = LocalContext.current
    var isSheetVisible by rememberSaveable { mutableStateOf(false) }

    val isLoading by mainViewModel.isLoading.collectAsState()
    val showError by mainViewModel.isError.collectAsState()
    val holdingsData by mainViewModel.holdingsList.collectAsState()

    val calculateTodaysPnlUseCase = CalculateTodaysPnlUseCase()
    val calculateCurrentValueUseCase = CalculateCurrentValueUseCase()
    val calculateTotalInvestmentUseCase = CalculateTotalInvestmentUseCase()

    LaunchedEffect(showError) {
        showError?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.fillMaxSize()) {
                ToggleTabs(
                    selectedTab = TabType.HOLDINGS,
                    onTabSelected = { }
                )
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    itemsIndexed(holdingsData) { _, holding ->
                        HoldingRow(item = holding)
                        Box(
                            modifier = Modifier
                                .height(0.5.dp)
                                .fillMaxWidth()
                                .background(Color.Gray.copy(alpha = 0.5f))
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .shadow(
                        elevation = 14.dp,
                        shape = RoundedCornerShape(8.dp),
                        ambientColor = Color.Black,
                        spotColor = Color.Black
                    )
                    .background(
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                        color = colorResource(id = R.color.sheetbg)
                    )
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .animateContentSize()
                    .padding(16.dp)
            ) {
                if (isSheetVisible) {
                    val todayPnl = calculateTodaysPnlUseCase.invoke(holdingsData)
                    Spacer(modifier = Modifier.height(10.dp))
                    PortfolioSummary(
                        stringResource(id = R.string.currentvalue),
                        stringResource(id = R.string.txt_rupee_value, calculateCurrentValueUseCase.invoke(holdingsData)),
                        Color.DarkGray
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    PortfolioSummary(
                        stringResource(id = R.string.total_investment_tag),
                        stringResource(id = R.string.txt_rupee_value, calculateTotalInvestmentUseCase.invoke(holdingsData)),
                        Color.DarkGray
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    PortfolioSummary(
                        stringResource(id = R.string.today_pnl),
                        stringResource(id = R.string.txt_rupee_value, todayPnl),
                        if (todayPnl >= 0) Color(0xFF00B386) else Color.Red
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .height(0.5.dp)
                            .fillMaxWidth()
                            .background(Color.Gray.copy(alpha = 0.5f))
                    )
                }
                TotalPnL(
                    holdingsData = holdingsData,
                    isExpanded = isSheetVisible,
                    onToggleClick = { isSheetVisible = !isSheetVisible }
                )
            }
        }

        if (isLoading) {
            Loader()
        }
    }
}