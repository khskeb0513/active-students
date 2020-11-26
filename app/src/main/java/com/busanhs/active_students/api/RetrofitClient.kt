package com.busanhs.active_students.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val service: RetrofitService = Retrofit.Builder()
        .baseUrl("https://school.busanhs.xyz/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitService::class.java)
}