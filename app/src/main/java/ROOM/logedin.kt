package com.example.pharmacy.Room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "loged in")
data class logedin(
    @PrimaryKey
    val email: String,
    val password: String,
)
