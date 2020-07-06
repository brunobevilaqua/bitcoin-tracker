package com.example.bitcoin_tracker.shared.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        fun getWSClient(baseUri: String): Retrofit {
            return Retrofit
                .Builder()
                .baseUrl(baseUri)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}