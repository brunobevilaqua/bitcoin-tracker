package com.example.ap2_covid_dashboard.api.covidreports

import com.example.bitcoin_tracker.api.ticker.GetTickerForCoinResponse
import com.example.bitcoin_tracker.dashboard.wallet.CoinEnum
import com.example.bitcoin_tracker.shared.config.RetrofitClient
import retrofit2.Call

class BitCoinWSClient() {

    private val BASE_URI = "https://www.mercadobitcoin.net/api/"

    private val api: BitCoinService

    init {
        val retrofit = RetrofitClient.getWSClient(BASE_URI)
        api = retrofit.create(BitCoinService::class.java)
    }

    fun getTickerForCoin(coin: CoinEnum): Call<GetTickerForCoinResponse> {
        return api.getTickerForCoin(coin)
    }
}