package com.example.pharmacy.Room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "customer_data")
data class customer(
    val address: String,
    val age: Int,
    val dateRigester: String,
    @PrimaryKey
    val email: String,
    val password: String,
    val phone: String,
    val username: String

)
