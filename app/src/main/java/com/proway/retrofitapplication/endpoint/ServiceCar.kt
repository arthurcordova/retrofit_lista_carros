package com.proway.retrofitapplication.endpoint

import com.proway.retrofitapplication.model.Marca
import retrofit2.Call
import retrofit2.http.GET

interface ServiceCar {

    @GET("/fipe/api/v1/carros/marcas")
    fun buscarMarcas(): Call<List<Marca>>

}