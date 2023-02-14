package com.example.pharmacy.API

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface Services {
    @POST("/api/admin_/add_pharmacist")
    fun add_pharmacist(@Body pharmacist: pharmacist):Call<Unit>
    @DELETE("/api/admin_/delete_pharmacist")
    fun delete_pharmacist(@Query("email") email:String):Call<Unit>
    @GET("/api/admin_/get_all_pharmacist")
    fun get_all_pharmacist():Call<pharmacist>
    @GET("/api/admin_/get_all_customerrs")
    fun get_all_customerrs():Call<List<allCustomers>>
    @POST("/api/admin_/add_category")
    fun add_category(@Body category: category):Call<Unit>
    @GET("/api/admin_/get_all_category")
    fun get_all_category():Call<List<category>>
    @DELETE("/api/admin_/delete_category")
    fun delete_category(@Query("type")type:String):Call<Unit>
    @POST("/api/admin_/add_medidcine")
    fun add_medidcine(
        @Query("imagePath")imagePath:String,
    @Body midicine: Midicine):Call<Unit>
    @DELETE("/api/admin_/delete_medicine")
    fun delete_medicine(@Query("id")id:Int):Call<Unit>
    @GET("/api/admin_/get_mididcines")
    fun get_mididcines():Call<List<allMidicines>>
    @GET("/api/admin_/get_all_prescription_item")
    fun get_all_prescription_item():Call<List<prescriptionItem>>
    @GET("/api/admin_/Get_full_data")
    fun Get_full_data():Call<List<allData>>
    @Multipart
    @POST("/api/admin_/AddImage")
    suspend fun add_image(
        @Part userData: MultipartBody.Part,
        @Part profileImage: MultipartBody.Part
    ): BasicApiResponse<Unit>
    @POST("/api/customer_/add_customer")
    fun add_customer(@Body customer: customer):Call<Unit>
    @POST("/api/customer_/login_customer")
    fun login_customer(@Body loginall: loginall):Call<Unit>
    @DELETE("/api/customer_/delete_customer")
    fun delete_customer(@Query("email")email:String):Call<Unit>
    @GET("/api/customer_/is_valid")
    fun is_valid(@Query("email")email:String):Call<String>
    @GET("/api/customer_/get_pharmacist_email")
    fun get_pharmacist_email():Call<List<callPharmacist>>
    @POST("/api/customer_/add-prescription")
    fun add_prescription(@Body customerAddPrecription:customerAddPrecription):Call<Unit>
    @GET("/api/customer_/Get_my_fulldata")
    fun Get_my_fulldata(@Query("email")email:String):Call<List<Unit>>
    @POST("/api/customer_/search_for_medicine")
    fun search_for_medicine(@Query("midname")midname:String):Call<Unit>
    @GET("/api/pharmacist_/get_all_prescription")
    fun get_all_prescription():Call<List<allPrescription>>
    @POST("/api/pharmacist_/ add_prescription_item")
    fun add_prescription_item(@Body prescriptionItem: prescriptionItem):Call<Unit>
    @DELETE("/api/pharmacist_/delete_item")
    fun delete_item(@Query("id")id:Int):Call<Unit>
    @GET("/api/pharmacist_/get_all_pharmacist_priscription")
    fun get_all_pharmacist_priscription(@Query("email")email:String):Call<List<Unit>>
    @POST("/api/admin_/add_manager")
    fun add_manager(@Body admin: admin):Call<Unit>
    @POST("/api/admin_/login_manager")
    fun login_manager(@Body loginall: loginall):Call<Unit>
    @DELETE("/api/admin_/delete_manager")
    fun delete_manager(@Query("email")email: String):Call<Unit>
}