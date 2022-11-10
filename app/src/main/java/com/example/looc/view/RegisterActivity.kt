package com.example.looc.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.looc.R

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        createSpinner()

        val nextBtn = findViewById<Button>(R.id.register_next)

        nextBtn.setOnClickListener {

            val studentId = findViewById<EditText>(R.id.register_student_id).text.toString()
            val password = findViewById<EditText>(R.id.register_pwd).text.toString()
            val name = findViewById<EditText>(R.id.register_name).text.toString()


            if (studentId.isEmpty() || password.isEmpty() || name.isEmpty()) {
                Toast.makeText(this.applicationContext, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, PreferenceActivity::class.java)
                intent.putExtra("id", studentId)
                intent.putExtra("pwd", password)
                intent.putExtra("name", name)
                startActivity(intent)
                finish()
            }

        }


    }

    private fun createSpinner() {

        val departmentSpinner: Spinner = findViewById(R.id.department_spinner)

        val departmentData = listOf(" - 선택하세요 - ", "컴퓨터융합학부", "기계공학부", "수학과", "영어영문학과")
        val adapter2 =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, departmentData)
        departmentSpinner.adapter = adapter2
        departmentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //position은 선택한 아이템의 위치를 넘겨주는 인자입니다.
                findViewById<TextView>(R.id.result2).text = departmentData.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


    }
}