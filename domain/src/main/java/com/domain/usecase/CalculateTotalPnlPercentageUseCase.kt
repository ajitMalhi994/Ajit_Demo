package com.domain.usecase

import com.domain.ext.roundToTwoDecimals
import com.domain.model.HoldingData

class CalculateTotalPnlPercentageUseCase(
    private val calculateTotalInvestmentUseCase: CalculateTotalInvestmentUseCase,
    private val calculateTotalPnlUseCase: CalculateTotalPnlUseCase
) {
    operator fun invoke(holdings: List<HoldingData>): Double {
        val investment = calculateTotalInvestmentUseCase(holdings)
        if (investment == 0.0) return 0.0
        val pnl = calculateTotalPnlUseCase(holdings)
        return ((pnl / investment) * 100).roundToTwoDecimals()
    }
}
