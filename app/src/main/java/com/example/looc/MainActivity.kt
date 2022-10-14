package com.example.looc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.looc.databinding.ActivityMainBinding
import com.example.looc.login.LoginMainActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_LooC)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goLoginIntent(binding)
    }


    private fun goLoginIntent(binding: ActivityMainBinding) {
        binding.goLoginBtn.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(this, LoginMainActivity::class.java)
            startActivity(intent)
            finish()
        })

    }



}