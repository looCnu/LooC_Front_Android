package com.example.looc.view

import RetrofitInterface
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Validators.or
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.looc.R
import com.example.looc.data.LectureDetailItem
import com.example.looc.server.RetrofitClient
import com.example.looc.viewmodel.ListViewModel
import io.reactivex.plugins.RxJavaPlugins.onError
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val lecturesAdapter1 = RecyclerViewAdapter(arrayListOf())
    private val lecturesAdapter2 = RecyclerViewAdapter(arrayListOf())
    private val lecturesAdapter3 = RecyclerViewAdapter(arrayListOf())
    private val lecturesAdapter4 = RecyclerViewAdapter(arrayListOf())



    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        val recommendLectureList = findViewById<RecyclerView>(R.id.recommend_recycler_view)
        recommendLectureList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = lecturesAdapter1
        }

        val departmentLectureList = findViewById<RecyclerView>(R.id.department_recycler_view)
        departmentLectureList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = lecturesAdapter2
        }

        val sportRecyclerView = findViewById<RecyclerView>(R.id.sport_recycler_view)
        sportRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = lecturesAdapter3
        }

        val onlineRecyclerView = findViewById<RecyclerView>(R.id.online_recycler_view)
        onlineRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = lecturesAdapter4
        }

        observeViewModel()


    }

    fun observeViewModel() {

        val recommendLectureList = findViewById<RecyclerView>(R.id.recommend_recycler_view)
        viewModel.looCLectures.observe(this, Observer {looCLectures ->
            looCLectures?.let {
                recommendLectureList.visibility = View.VISIBLE
                lecturesAdapter1.updateLecture(it)
            }
        })

        val departmentScoreLectureList = findViewById<RecyclerView>(R.id.department_recycler_view)
        viewModel.departmentLectures.observe(this, Observer {departmentLectures ->
            departmentLectures?.let {
                departmentScoreLectureList.visibility = View.VISIBLE
                lecturesAdapter2.updateLecture(it) }
        })

        val sportTableRecyclerView = findViewById<RecyclerView>(R.id.sport_recycler_view)
        viewModel.sportLectures.observe(this, Observer {sportLectures ->
            sportLectures?.let {
                sportTableRecyclerView.visibility = View.VISIBLE
                lecturesAdapter3.updateLecture(it) }
        })

        val onlineRecyclerView = findViewById<RecyclerView>(R.id.online_recycler_view)
        viewModel.offlineLectures.observe(this, Observer {offlineLectures ->
            offlineLectures?.let {
                onlineRecyclerView.visibility = View.VISIBLE
                lecturesAdapter4.updateLecture(it) }
        })

        /* viewModel.lecturesLoadError.observe(this, Observer { isError ->
             list_error.visibility = if(isError == "") View.GONE else View.VISIBLE
         })

         viewModel.loading.observe(this, Observer { isLoading ->
             isLoading?.let {
                 loading_view.visibility = if(it) View.VISIBLE else View.GONE
                 if(it) {
                     list_error.visibility = View.GONE
                     countriesList.visibility = View.GONE
                 }
             }
         })*/
    }



}

