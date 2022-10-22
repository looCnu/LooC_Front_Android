package com.example.looc.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.looc.R
import com.example.looc.view.BottomNavActivity
import com.example.looc.view.MainActivity
import com.example.looc.view.RegisterActivity

class LoginMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_LooC)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login_main)



        val loginBtn = findViewById<Button>(R.id.login_btn)

        loginBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }



    }

    private fun isLogin() {
        val userId = findViewById<EditText>(R.id.login_id_et)
        val userPw = findViewById<EditText>(R.id.login_pwd_et)

    }



}