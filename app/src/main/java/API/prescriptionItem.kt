package com.example.pharmacy.API


import com.google.gson.annotations.SerializedName

data class prescriptionItem(
    @SerializedName("date_register")
    val dateRegister: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("midicineid")
    val midicineid: Int,
    @SerializedName("prescriptionid")
    val prescriptionid: Int
)