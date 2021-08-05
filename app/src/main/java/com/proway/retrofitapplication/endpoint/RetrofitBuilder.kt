package com.proway.retrofitapplication.endpoint

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://parallelum.com.br")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getServiceCarInstance(): ServiceCar {
        return retrofit.create(ServiceCar::class.java)
    }

}