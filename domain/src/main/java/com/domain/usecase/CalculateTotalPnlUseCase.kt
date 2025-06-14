package com.domain.usecase

import com.domain.ext.roundToTwoDecimals
import com.domain.model.HoldingData

class CalculateTotalPnlUseCase(
    private val calculateCurrentValueUseCase: CalculateCurrentValueUseCase,
    private val calculateTotalInvestmentUseCase: CalculateTotalInvestmentUseCase
) {
    operator fun invoke(holdings: List<HoldingData>): Double {
        val currentValue = calculateCurrentValueUseCase(holdings)
        val investment = calculateTotalInvestmentUseCase(holdings)
        return (currentValue - investment).roundToTwoDecimals()
    }
}
