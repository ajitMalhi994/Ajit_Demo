package com.domain.model

import com.google.gson.annotations.SerializedName


data class HoldingsResponse(
    @SerializedName("data")
    val data: Data
)