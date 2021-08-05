package com.proway.retrofitapplication.model

import com.google.gson.annotations.SerializedName

data class Marca(
    @SerializedName("codigo")
    val id: String,
    @SerializedName("nome")
    val name: String,
)
