package com.example.pharmacy.API


import com.google.gson.annotations.SerializedName

data class allPrescription(
    @SerializedName("customer")
    val customer: Any,
    @SerializedName("date_detection")
    val dateDetection: String,
    @SerializedName("date_register")
    val dateRegister: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("midicines")
    val midicines: Any,
    @SerializedName("patient_address")
    val patientAddress: String,
    @SerializedName("patient_age")
    val patientAge: String,
    @SerializedName("patient_name")
    val patientName: String,
    @SerializedName("pharmacist")
    val pharmacist: Any,
    @SerializedName("pharmacist_email")
    val pharmacistEmail: String,
    @SerializedName("prescription_Items")
    val prescriptionItems: Any
)