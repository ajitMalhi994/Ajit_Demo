package com.domain.model

import com.google.gson.annotations.SerializedName


data class Data(
    @SerializedName("userHolding")
    val userHolding: List<HoldingData>
)