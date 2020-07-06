package com.example.bitcoin_tracker.api.ticker

import com.google.gson.annotations.SerializedName

data class GetTickerForCoinResponse (
    @SerializedName("ticker")
    var ticker: Ticker
)