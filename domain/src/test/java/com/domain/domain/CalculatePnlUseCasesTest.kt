package com.domain.domain

import com.domain.model.HoldingData
import com.domain.usecase.CalculateSinglePnlUseCase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatePnlUseCasesTest {

    private lateinit var calculateSinglePnlUseCase: CalculateSinglePnlUseCase

    @Before
    fun setup() {
        calculateSinglePnlUseCase = CalculateSinglePnlUseCase()
    }

    @Test
    fun `calculate single pnl should be correct`() {
        val pnl = calculateSinglePnlUseCase(
            HoldingData(symbol = "TEST", quantity = 10, avgPrice = 100.0, ltp = 110.0, close = 105.0)
        )
        assertEquals(-50.0, pnl, 0.01)
    }
}
