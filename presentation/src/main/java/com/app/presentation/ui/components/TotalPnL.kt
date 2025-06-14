package com.app.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.presentation.R
import com.app.presentation.ui.viewmodels.CalculatePnlViewModel
import com.domain.model.HoldingData
import com.domain.usecase.CalculateCurrentValueUseCase
import com.domain.usecase.CalculateTotalInvestmentUseCase
import com.domain.usecase.CalculateTotalPnlPercentageUseCase
import com.domain.usecase.CalculateTotalPnlUseCase
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TotalPnL(
    holdingsData: List<HoldingData>,
    isExpanded: Boolean,
    onToggleClick: () -> Unit
) {
    val calculateCurrentValueUseCase = CalculateCurrentValueUseCase()
    val calculateTotalInvestmentUseCase = CalculateTotalInvestmentUseCase()
    val calculateTotalPnlUseCase =  CalculateTotalPnlUseCase(calculateCurrentValueUseCase, calculateTotalInvestmentUseCase)
    val calculateTotalPnlPercentageUseCase =  CalculateTotalPnlPercentageUseCase(calculateTotalInvestmentUseCase, calculateTotalPnlUseCase)
    val totalpnl = calculateTotalPnlUseCase.invoke(holdingsData)
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                context.getString(R.string.profit_n_loss),
                color = Color.DarkGray,
                fontSize = 16.sp
            )
            IconButton(onClick = onToggleClick) {
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                    contentDescription = stringResource(id = R.string.toggle_sort)
                )
            }
        }
        Text(
            text = stringResource(id = R.string.total_pnl_display, totalpnl, calculateTotalPnlPercentageUseCase.invoke(holdingsData)),
            color = if (totalpnl >= 0) Color(0xFF00B386) else Color.Red,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp
        )
    }
}
