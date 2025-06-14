package com.domain.repository

import com.domain.common.ResponseState
import com.domain.model.HoldingsResponse

interface MyRepository {
    suspend fun fetchHoldingsData(): ResponseState<HoldingsResponse>?
}