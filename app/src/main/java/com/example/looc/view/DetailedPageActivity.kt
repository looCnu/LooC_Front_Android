package com.example.looc.view

import RetrofitInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.looc.R
import com.example.looc.server.RetrofitClient
import retrofit2.create

class DetailedPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_page)


        val retrofit = RetrofitClient.retrofit
        retrofit.create(RetrofitInterface::class.java)








    }





}