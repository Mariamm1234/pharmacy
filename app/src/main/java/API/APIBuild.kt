package com.example.pharmacy.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIBuild {
    val okHttp= OkHttpClient.Builder().build()
    private val retrofit= Retrofit.Builder()
        .baseUrl("http://mostafagamal2001-001-site1.ftempurl.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp)
        .build()
    fun buildServices(): Services {
        return retrofit.create(Services::class.java)
    }
}