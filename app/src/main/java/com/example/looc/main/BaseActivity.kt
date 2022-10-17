package com.example.looc.main

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    fun showBackIcon () {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}