package com.example.pharmacy.API


import com.google.gson.annotations.SerializedName

data class allCustomers(
    @SerializedName("address")
    val address: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("date_rigester")
    val dateRigester: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("prescriptions")
    val prescriptions: Any,
    @SerializedName("username")
    val username: String
)