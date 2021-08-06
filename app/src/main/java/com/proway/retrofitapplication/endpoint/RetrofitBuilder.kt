package com.proway.retrofitapplication.endpoint

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofitParallelum = Retrofit.Builder()
        .baseUrl("https://parallelum.com.br")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofirFake = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getServiceCarInstance(): ServiceCar {
        return retrofitParallelum.create(ServiceCar::class.java)
    }

    fun getServiceUserInstance(): ServiceUser {
        return retrofirFake.create(ServiceUser::class.java)
    }

}