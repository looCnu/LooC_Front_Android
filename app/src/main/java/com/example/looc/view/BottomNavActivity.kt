package com.example.looc.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.looc.R
import com.example.looc.databinding.ActivityBottomNavBinding


class BottomNavActivity : AppCompatActivity() {


    private lateinit var binding: ActivityBottomNavBinding
    //바인딩을 시작한다.
    private val fragmentManager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()

    }

    private fun setUpUI() {
        fragmentManager.beginTransaction().add(
            R.id.container,
            FeedFragment()
        ).commit()

    }


}