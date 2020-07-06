package com.example.bitcoin_tracker.api.ticker

import com.google.gson.annotations.SerializedName

data class Ticker(
    @SerializedName("high")
    var high: Long,

    @SerializedName("low")
    var low: Long,

    @SerializedName("vol")
    var vol: Long,

    @SerializedName("last")
    var last: Long,

    @SerializedName("buy")
    var buy: Long,

    @SerializedName("sell")
    var sell: Long,

    @SerializedName("date")
    var date: String
)