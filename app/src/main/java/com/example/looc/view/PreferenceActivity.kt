package com.example.looc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.looc.R

class PreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencce)

        val studentID = intent.getStringExtra("id")
        val password = intent.getStringExtra("pwd")
        val name = intent.getStringExtra("name")

        Log.d("testt", "1. "+ studentID +""+ password+""+name)

    }
}