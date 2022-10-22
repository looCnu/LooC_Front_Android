package com.example.looc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.looc.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        supportFragmentManager.beginTransaction().add(
            R.id.container,
            FeedFragment()
        ).commit()
    }
}