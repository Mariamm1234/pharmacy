package com.example.pharmacy.API


import com.google.gson.annotations.SerializedName

data class admin(
    @SerializedName("address")
    val address: String,
    @SerializedName("date_birth")
    val dateBirth: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String
)