package com.domain.usecase

import com.domain.ext.roundToTwoDecimals
import com.domain.model.HoldingData

class CalculateTotalInvestmentUseCase {
    operator fun invoke(holdings: List<HoldingData>): Double {
        return holdings.sumOf { it.avgPrice * it.quantity }.roundToTwoDecimals()
    }
}
