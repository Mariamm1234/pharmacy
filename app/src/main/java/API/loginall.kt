package com.example.pharmacy.API


import com.google.gson.annotations.SerializedName

data class loginall(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)