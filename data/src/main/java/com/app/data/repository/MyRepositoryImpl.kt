package com.app.data.repository

import com.app.data.api.HoldingsApiService
import com.domain.common.ResponseState
import com.domain.model.HoldingsResponse
import com.domain.repository.MyRepository

class MyRepositoryImpl(private val api: HoldingsApiService): MyRepository {
    override suspend fun fetchHoldingsData(): ResponseState<HoldingsResponse>? {
        return try {
            val holdingsResponse = api.getHoldings()
            val holdingsResponseBody = holdingsResponse.body()
            if (holdingsResponse.isSuccessful && holdingsResponseBody != null) {
                ResponseState.SuccessState(holdingsResponseBody)
            } else {
                ResponseState.ErrorState("Error: ${holdingsResponse.code()}")
            }
        } catch (e: Exception){
            ResponseState.ErrorState(e.message.toString())
        }
    }
}