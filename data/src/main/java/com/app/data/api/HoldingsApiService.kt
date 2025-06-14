package com.app.data.api

import com.domain.model.HoldingsResponse
import retrofit2.Response
import retrofit2.http.GET

interface HoldingsApiService {
    @GET("/")
    suspend fun getHoldings(): Response<HoldingsResponse>
}
