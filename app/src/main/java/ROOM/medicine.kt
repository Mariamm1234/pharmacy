package com.example.pharmacy.Room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "medicine")
data class medicine(
    val concentration: Int,
    val exDate: String,
    @PrimaryKey
    val id: Int,
    val imagePath: String,
    val indications: String,
    val manufacturer: String,
    val name: String,
    val price: Int,
    val proDate: String,
    val quantity: Int,
    val type: String
)
