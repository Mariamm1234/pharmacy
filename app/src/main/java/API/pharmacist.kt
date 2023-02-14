package com.example.pharmacy.API


import com.google.gson.annotations.SerializedName

data class pharmacist(
    @SerializedName("address")
    val address: String,
    @SerializedName("cardid")
    val cardid: String,
    @SerializedName("date_birth")
    val dateBirth: String,
    @SerializedName("date_graduation")
    val dateGraduation: String,
    @SerializedName("date_register")
    val dateRegister: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("pharmacist_email")
    val pharmacistEmail: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("prescriptions")
    val prescriptions: Any,
    @SerializedName("years_experience")
    val yearsExperience: Int
)