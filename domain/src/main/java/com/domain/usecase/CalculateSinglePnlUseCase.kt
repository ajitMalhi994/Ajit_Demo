package com.domain.usecase

import com.domain.model.HoldingData
import com.domain.ext.roundToTwoDecimals

class CalculateSinglePnlUseCase {
    operator fun invoke(data: HoldingData): Double {
        return ((data.close - data.ltp) * data.quantity).roundToTwoDecimals()
    }
}
