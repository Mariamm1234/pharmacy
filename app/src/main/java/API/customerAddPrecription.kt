package com.example.pharmacy.API


import com.google.gson.annotations.SerializedName

data class customerAddPrecription(
    @SerializedName("date_detection")
    val dateDetection: String,
    @SerializedName("date_register")
    val dateRegister: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("midicines")
    val midicines: List<Midicine>,
    @SerializedName("patient_address")
    val patientAddress: String,
    @SerializedName("patient_age")
    val patientAge: Int,
    @SerializedName("patient_name")
    val patientName: String,
    @SerializedName("pharmacist_email")
    val pharmacistEmail: String,
    @SerializedName("symptoms_of_the_disease")
    val symptomsOfTheDisease: String
)