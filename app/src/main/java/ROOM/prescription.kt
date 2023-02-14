package com.example.pharmacy.Room

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity(tableName = "prescribtion")
data class prescription(
    val customer: Any,
    val dateDetection: String,
    val dateRegister: String,
    val email: String,
    val id: Int,
    val midicines: Any,
    val patientAddress: String,
    val patientAge: String,
    val patientName: String,
    val pharmacist: Any,
    val pharmacistEmail: String,
    val prescriptionItems: Any
)
