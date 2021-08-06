package com.proway.retrofitapplication.model

import com.google.gson.annotations.SerializedName

data class Credentials(
    @SerializedName("username")
    val email: String,
    @SerializedName("password")
    val pwd: String
)
