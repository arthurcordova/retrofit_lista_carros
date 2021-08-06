package com.proway.retrofitapplication.endpoint

import com.proway.retrofitapplication.model.Auth
import com.proway.retrofitapplication.model.Credentials
import com.proway.retrofitapplication.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServiceUser {

    @GET("/users/1")
    fun getUser(): Call<User>

    @GET("/users")
    fun getAll(): Call<List<User>>

    @POST("/auth/login")
    fun login(@Body credentials: Credentials): Call<Auth>

}