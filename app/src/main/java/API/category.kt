package com.example.pharmacy.API


import com.google.gson.annotations.SerializedName

data class category(
    @SerializedName("type")
    val type: String
)