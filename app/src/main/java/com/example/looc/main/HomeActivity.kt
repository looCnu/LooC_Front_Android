package com.example.looc.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.looc.R
import com.example.looc.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {


    private lateinit var binding: ActivityHomeBinding
    //바인딩을 시작한다.

    private val fragmentManager = supportFragmentManager
    private val homeFragment = HomeFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()

    }

    private fun setUpUI() {
        TODO("Not yet implemented")
        fragmentManager.beginTransaction().apply {
            add(R.id.container, homeFragment ).commit()
        }
    }


}