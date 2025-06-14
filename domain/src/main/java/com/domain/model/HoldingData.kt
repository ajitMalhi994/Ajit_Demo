package com.domain.model

import com.google.gson.annotations.SerializedName

data class HoldingData(
    @SerializedName("avgPrice")
    val avgPrice: Double,
    @SerializedName("close")
    val close: Double,
    @SerializedName("ltp")
    val ltp: Double,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("symbol")
    val symbol: String
)