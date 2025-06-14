package com.domain.ext

import android.annotation.SuppressLint

@SuppressLint("DefaultLocale")
fun Double.roundToTwoDecimals(): Double {
    return String.format("%.2f", this).toDouble()
}