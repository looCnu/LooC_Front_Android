package com.example.looc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.looc.R
import java.text.FieldPosition

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        createSpinner()

    }

    private fun createSpinner(){
        val universitySpinner : Spinner = findViewById(R.id.university_spinner)
        val universityList : ArrayList<String> = ArrayList()

        val data = listOf(" - 선택하세요 - ",  "공과대학" , "사범대학", "인문대학", "농업대학" )
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        universitySpinner.adapter = adapter

        universitySpinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{


            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //position은 선택한 아이템의 위치를 넘겨주는 인자입니다.
                findViewById<TextView>(R.id.result).text = data.get(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        universityList.add("공과대학")
        universityList.add("경상대학")
    }
}