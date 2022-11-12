package com.example.looc.view

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.devtides.coroutinesretrofit.view.loadImage
import com.example.looc.R
import com.example.looc.data.LectureDetailItem
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.newCoroutineContext
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.coroutineContext

class RecyclerViewAdapter(
    var lectureList : ArrayList<LectureDetailItem>
) : RecyclerView.Adapter<RecyclerViewAdapter.LectureViewHolder>(){

    init {

    }

    fun updateLecture(newLectures: List<LectureDetailItem>) {
        lectureList.clear()
        lectureList.addAll(newLectures)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LectureViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_poster, parent, false)
    )


    override fun onBindViewHolder(holder: LectureViewHolder, position: Int) {
        holder.bind(lectureList[position])

    }

    override fun getItemCount(): Int {
        return  lectureList.size
    }

    class LectureViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val globalView = view
        private val imageView = globalView.findViewById<ImageView>(R.id.poster_image)


        fun bind(lectureDetailItem: LectureDetailItem){
            imageView.loadImage("http://172.16.0.94:5000/static/images/"+lectureDetailItem.image)

            imageView.setOnClickListener {
                val intent = Intent(globalView.context, DetailedPageActivity::class.java)
                intent.putExtra("name", lectureDetailItem.name)
                var keyword : String = ""


                if (lectureDetailItem.keyword != null){
                    lectureDetailItem.keyword!!.forEach {
                        keyword += it.toString() + " "
                        Log.d("testt", keyword)
                    }
                }

                Log.d("testtt", keyword)
                intent.putExtra("keyword", keyword)
                intent.putExtra("professor", lectureDetailItem.professor)
                intent.putExtra("credit", lectureDetailItem.credit.toString())
                intent.putExtra("content", lectureDetailItem.description)
                intent.putExtra("category", lectureDetailItem.category)
                intent.putExtra("room", lectureDetailItem.room)
                intent.putExtra("time", lectureDetailItem.time)
                intent.putExtra("score", lectureDetailItem.score.toString())


                globalView.context.startActivity(intent);
            }
        }




    }

}
