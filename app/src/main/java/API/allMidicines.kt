package com.example.pharmacy.API


import com.google.gson.annotations.SerializedName

data class allMidicines(
    @SerializedName("category")
    val category: category,
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
    @SerializedName("prescription_Items")
    val prescriptionItems: Any,
    @SerializedName("price")
    val price: Int,
    @SerializedName("pro_date")
    val proDate: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("type")
    val type: String
)