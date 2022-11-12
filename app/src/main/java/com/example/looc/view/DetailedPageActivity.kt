package com.example.looc.view

import RetrofitInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.looc.R
import com.example.looc.server.RetrofitClient
import org.w3c.dom.Text
import retrofit2.create

class DetailedPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_page)

        val lectureName = intent.getStringExtra("name")
        val lectureProfessor = intent.getStringExtra("professor")
        val lectureContent = intent.getStringExtra("content")
        val lectureCredit = intent.getStringExtra("credit")
        val lectureCategory = intent.getStringExtra("category")
        val lectureRoom = intent.getStringExtra("room")
        val lectureTime = intent.getStringExtra("time")
        val lectureScore = intent.getStringExtra("score")
        val lectureKeyword = intent.getStringExtra("keyword")

        findViewById<TextView>(R.id.lecture_keyword1)
        findViewById<TextView>(R.id.lecture_keyword2)
        findViewById<TextView>(R.id.lecture_keyword3)
        findViewById<TextView>(R.id.lecture_keyword4)


        val lectureKeywordList = lectureKeyword?.split(" ")

        if (lectureKeywordList?.get(0) != null && !lectureKeywordList?.get(0).equals("")){
            findViewById<TextView>(R.id.lecture_keyword1).text = lectureKeywordList.get(0)
            findViewById<TextView>(R.id.lecture_keyword1).visibility = View.VISIBLE
        }

        if (lectureKeywordList?.get(1) != null && !lectureKeywordList?.get(1).equals("")){
            findViewById<TextView>(R.id.lecture_keyword2).text = lectureKeywordList.get(1)
            findViewById<TextView>(R.id.lecture_keyword2).visibility = View.VISIBLE
        }
        if (lectureKeywordList?.get(2) != null && !lectureKeywordList?.get(2).equals("")){
            findViewById<TextView>(R.id.lecture_keyword3).text = lectureKeywordList.get(2)
            findViewById<TextView>(R.id.lecture_keyword3).visibility = View.VISIBLE
        }
        if (lectureKeywordList?.get(3) != null && !lectureKeywordList?.get(3).equals("") ){
            findViewById<TextView>(R.id.lecture_keyword4).text = lectureKeywordList.get(3)
            findViewById<TextView>(R.id.lecture_keyword4).visibility = View.VISIBLE
        }






        findViewById<TextView>(R.id.lecture_name).text = lectureName
        findViewById<TextView>(R.id.lecture_professor).text = lectureProfessor
        findViewById<TextView>(R.id.lecture_content).text = lectureContent
        findViewById<TextView>(R.id.lecture_credit).text = lectureCredit + "학점"
        findViewById<TextView>(R.id.lecture_category).text = lectureCategory
        findViewById<TextView>(R.id.lecture_room).text = lectureRoom
        findViewById<TextView>(R.id.lecture_time).text = lectureTime
        findViewById<TextView>(R.id.lecture_score).text = lectureScore+"/5점"











    }

}