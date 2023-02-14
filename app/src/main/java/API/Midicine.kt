package com.example.pharmacy.API


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Midicine(
    @SerializedName("concentration")
    val concentration: Int,
    @SerializedName("ex_date")
    val exDate: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imagePath")
    val imagePath: String,
    @SerializedName("indications")
    val indications: String,
    @SerializedName("manufacturer")
    val manufacturer: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("pro_date")
    val proDate: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("type")
    val type: String
):Parcelable