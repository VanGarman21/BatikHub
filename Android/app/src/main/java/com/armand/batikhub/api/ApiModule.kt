package com.armand.batikhub.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiModule {
    private const val BASE_URL = "https://batikhub-api-smdkgsrncq-et.a.run.app"

    val batikApi: BatikApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BatikApi::class.java)
    }
}