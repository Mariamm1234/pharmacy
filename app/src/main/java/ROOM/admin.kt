package com.example.pharmacy.Room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "admin_data")
data class admin(
    val address: String,
    val dateBirth: String,
   @PrimaryKey
    val email: String,
    val name: String,
    val password: String,
    val phone: String
)
