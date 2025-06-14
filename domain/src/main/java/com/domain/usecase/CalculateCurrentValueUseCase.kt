package com.domain.usecase

import com.domain.ext.roundToTwoDecimals
import com.domain.model.HoldingData

class CalculateCurrentValueUseCase {
    operator fun invoke(holdings: List<HoldingData>): Double {
        return holdings.sumOf { it.ltp * it.quantity }.roundToTwoDecimals()
    }
}
