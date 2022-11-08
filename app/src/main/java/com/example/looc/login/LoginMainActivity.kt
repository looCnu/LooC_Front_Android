package com.example.looc.login

import LoginService
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.looc.R
import com.example.looc.db.DataModal
import com.example.looc.db.Login
import com.example.looc.view.BottomNavActivity
import com.example.looc.view.MainActivity
import com.example.looc.view.RegisterActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginMainActivity : AppCompatActivity() {

    private var login: Login? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_LooC)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_main)

        var retrofit = Retrofit.Builder()
            .baseUrl("https://172.16.0.94:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var dialog = AlertDialog.Builder(this@LoginMainActivity)
        var loginService: LoginService = retrofit.create(LoginService::class.java)
        val loginBtn = findViewById<Button>(R.id.login_btn)

        loginBtn.setOnClickListener {

            val loginId = findViewById<EditText>(R.id.login_id_et).text.toString()
            val loginPw = findViewById<EditText>(R.id.login_pwd_et).text.toString()

            if (loginId.isEmpty() || loginPw.isEmpty()) {
                Toast.makeText(this.applicationContext, "아이디, 비밀번호를 입력해주세요", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val dataModal : DataModal = DataModal(loginId, loginPw)

//                loginService.requestLogin(dataModal).enqueue(object : Callback<Login> {
//                    override fun onResponse(call: Call<Login>, response: Response<Login>) {
//                        login = response.body()
//                        Log.d("LOGIN", "msg : " + login?.success.toString())
//                        dialog.setTitle(login?.success.toString())
//                        dialog.show()
//
//                    }
//
//                    override fun onFailure(call: Call<Login>, t: Throwable) {
//                        Log.e("LOGIN",""+t.message)
//                        dialog.setTitle("에러")
//                        dialog.setMessage("호출실패했습니다.")
//                        dialog.show()
//                    }
//                })


                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()


            }

            val notMemberPage = findViewById<TextView>(R.id.register_notice_text).setOnClickListener {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                    finish()
                }


        }


    }
}