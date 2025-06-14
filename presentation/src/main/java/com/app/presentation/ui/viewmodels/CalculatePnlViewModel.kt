package com.app.presentation.ui.viewmodels

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.domain.ext.roundToTwoDecimals
import com.domain.model.HoldingData

@SuppressLint("DefaultLocale")
class CalculatePnlViewModel: ViewModel() {

    /*fun calculateSinglePnl(data: HoldingData): Double {
        return ((data.close - data.ltp) * data.quantity).roundToTwoDecimals()
    }

    fun calculateCurrentValue(holdings: List<HoldingData>): Double {
        return holdings.sumOf { it.ltp * it.quantity }.roundToTwoDecimals()
    }

    fun calculateTotalInvestment(holdings: List<HoldingData>): Double {
        return holdings.sumOf { it.avgPrice * it.quantity }.roundToTwoDecimals()
    }

    fun calculateTotalPNL(holdings: List<HoldingData>): Double {
        val currentValue = calculateCurrentValue(holdings)
        val totalInvestment = calculateTotalInvestment(holdings)
        return (currentValue - totalInvestment).roundToTwoDecimals()
    }

    fun calculateTodaysPNL(holdings: List<HoldingData>): Double {
        return holdings.sumOf { (it.close - it.ltp) * it.quantity }.roundToTwoDecimals()
    }

    fun calculateTotalPNLPercentage(holdings: List<HoldingData>): Double {
        val totalInvestment = calculateTotalInvestment(holdings)
        if (totalInvestment == 0.0) return 0.0
        val totalPNL = calculateTotalPNL(holdings)
        return ((totalPNL / totalInvestment) * 100).roundToTwoDecimals()
    }*/
}