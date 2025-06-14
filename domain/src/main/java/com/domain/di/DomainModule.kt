package com.domain.di

import com.domain.usecase.CalculateCurrentValueUseCase
import com.domain.usecase.CalculateSinglePnlUseCase
import com.domain.usecase.CalculateTodaysPnlUseCase
import com.domain.usecase.CalculateTotalInvestmentUseCase
import com.domain.usecase.CalculateTotalPnlPercentageUseCase
import com.domain.usecase.CalculateTotalPnlUseCase
import com.domain.usecase.FetchHoldingsUseCase
import org.koin.dsl.module


val domainModule = module {
    single { FetchHoldingsUseCase(get()) }
    single { CalculateCurrentValueUseCase() }
    single { CalculateSinglePnlUseCase() }
    single { CalculateTodaysPnlUseCase() }
    single { CalculateTotalPnlUseCase(get(), get()) }
    single { CalculateTotalInvestmentUseCase() }
    single { CalculateTotalPnlPercentageUseCase(get(), get()) }
}