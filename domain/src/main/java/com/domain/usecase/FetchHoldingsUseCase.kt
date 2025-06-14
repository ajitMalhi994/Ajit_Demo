package com.domain.usecase

import com.domain.common.ResponseState
import com.domain.domain.R
import com.domain.model.HoldingsResponse
import com.domain.repository.MyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FetchHoldingsUseCase(private val repository: MyRepository) {
    suspend operator fun invoke(): Flow<ResponseState<HoldingsResponse>> = flow {
        val holdingsResponse = repository.fetchHoldingsData()
        if (holdingsResponse != null) {
            emit(holdingsResponse)
        } else {
            emit(ResponseState.ErrorState(message = R.string.data_fetch_error_msg.toString()))
        }
    }
}