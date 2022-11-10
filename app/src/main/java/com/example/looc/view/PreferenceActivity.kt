package com.example.looc.view

import RetrofitInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import com.example.looc.R
import com.example.looc.data.RegisterDetails
import com.example.looc.server.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class PreferenceActivity : AppCompatActivity() {

    private val preferList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencce)

        val studentID = intent.getStringExtra("id")
        val password = intent.getStringExtra("pwd")
        val name = intent.getStringExtra("name")



        findViewById<Button>(R.id.prefer_next_btn).setOnClickListener {

            val registerDetails : RegisterDetails = RegisterDetails(studentID!!, password!!, name!!, "컴퓨터 융합학부" , preferList)

            val intent = Intent(this, ProgressBarActivity::class.java)
            startActivity(intent)
            finish()

            val retrofit = RetrofitClient.retrofit

            retrofit.create(RetrofitInterface::class.java).register(registerDetails).enqueue(object : Callback<RegisterDetails>{
                override fun onResponse(
                    call: Call<RegisterDetails>,
                    response: Response<RegisterDetails>
                ) {
                    val responseRegisterDetails = response.body()
                    Log.d("testt", responseRegisterDetails!!.name.toString())

                }

                override fun onFailure(call: Call<RegisterDetails>, t: Throwable) {
                    Log.d("testt", "회원가입 요청 실패")
                }
            })
        }


        Log.d("testt", "1. " + studentID + "" + password + "" + name)


    }


    fun onCheckboxClicked(view: View): MutableList<String> {

        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.prefer_sport -> {
                    if (checked) {
                        preferList.add("sports")
                        Log.d("testt", "체크박스 운동")
                    }
                }
                R.id.prefer_music -> {
                    if (checked) {
                        preferList.add("sports")
                    }
                }
                R.id.prefer_sport -> {
                    if (checked) {
                        preferList.add("sports")
                    }
                }
                R.id.prefer_language -> {
                    if (checked) {
                        preferList.add("sports")
                    }
                }
            }
        }
        return preferList
    }

}