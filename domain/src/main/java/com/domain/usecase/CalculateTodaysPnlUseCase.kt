package com.domain.usecase

import com.domain.ext.roundToTwoDecimals
import com.domain.model.HoldingData

class CalculateTodaysPnlUseCase {
    operator fun invoke(holdings: List<HoldingData>): Double {
        return holdings.sumOf { (it.close - it.ltp) * it.quantity }.roundToTwoDecimals()
    }
}
