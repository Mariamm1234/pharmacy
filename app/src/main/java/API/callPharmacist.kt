package com.example.pharmacy.API


import com.google.gson.annotations.SerializedName

data class callPharmacist(
    @SerializedName("name")
    val name: String,
    @SerializedName("pharmacist_email")
    val pharmacistEmail: String
)