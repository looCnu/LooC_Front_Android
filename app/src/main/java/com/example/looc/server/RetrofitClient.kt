package com.example.looc.server

import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager

object RetrofitClient{
    private const val BASE_URL = "http://172.16.0.94:5000/looC/"


    var builder = OkHttpClient().newBuilder()
    var okHttpClient = builder
        .cookieJar(JavaNetCookieJar(CookieManager()))
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}