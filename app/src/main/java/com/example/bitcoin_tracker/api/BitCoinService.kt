package com.example.ap2_covid_dashboard.api.covidreports

import com.example.bitcoin_tracker.api.ticker.GetTickerForCoinResponse
import com.example.bitcoin_tracker.dashboard.wallet.CoinEnum
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BitCoinService {

    @GET("{coin}/ticker")
    fun getTickerForCoin(@Path("coin") date: CoinEnum): Call<GetTickerForCoinResponse>

}