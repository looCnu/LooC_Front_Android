package com.example.looc.view

import RetrofitInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.looc.R
import com.example.looc.data.LectureDetailItem
import com.example.looc.server.RetrofitClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    fun loadImage(imageUrl: String): Bitmap? {
        var bitmap: Bitmap? = null
        val connection: HttpURLConnection?

        try {
            val url = URL(imageUrl)
            connection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "GET" // request 방식 설정
            connection.connectTimeout = 10000 // 10초의 타임아웃
            connection.doOutput = true // OutPutStream으로 데이터를 넘겨주겠다고 설정
            connection.doInput = true // InputStream으로 데이터를 읽겠다는 설정
            connection.useCaches = true // 캐싱 여부
            connection.connect()

            val resCode = connection.responseCode // 연결 상태 확인

            if (resCode == HttpURLConnection.HTTP_OK) { // 200일때 bitmap으로 변경
                val input = connection.inputStream
                bitmap = BitmapFactory.decodeStream(input) // BitmapFactory의 메소드를 통해 InputStream으로부터 Bitmap을 만들어 준다.
                connection.disconnect()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bitmap
    }


    override fun onCreate(savedInstanceState: Bundle?) = runBlocking {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//       val imageView = findViewById<ImageView>(R.id.test_image)
//       Glide.with(this).load("https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9791190977852.jpg").into(imageView)

        val recommendRecyclerView = findViewById<RecyclerView>(R.id.recommend_recycler_view)

        var bitmap: Bitmap? = null

        val recommendLectureList = mutableListOf<String>()

        val job = GlobalScope.launch {
            bitmap = loadImage("https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9791190977852.jpg")

        }
        job.join()

        Log.d("testt", bitmap.toString())
        findViewById<ImageView>(R.id.test_image).setImageBitmap(bitmap)

        val retrofit = RetrofitClient.retrofit
        retrofit.create(RetrofitInterface::class.java).getLectures().enqueue(object : Callback<ArrayList<LectureDetailItem>>{
            override fun onResponse(
                call: Call<ArrayList<LectureDetailItem>>,
                response: Response<ArrayList<LectureDetailItem>>
            ) {
                if(response.isSuccessful){

                    val lecturePoster = response.body()
                    recommendLectureList.add("http://172.16.0.94:5000/static/images/"+lecturePoster!!.get(0).image)
                    recommendRecyclerView.adapter = RecyclerViewAdapter(recommendLectureList, LayoutInflater.from(applicationContext))

                }
            }
            override fun onFailure(call: Call<ArrayList<LectureDetailItem>>, t: Throwable) {
                Log.d("testt", "메인화면 이미지 불러오기 실패")
            }
        })


    }


}

class RecyclerViewAdapter(
    var lectureList : List<String>,
    var inflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //inner class
        val lectureImage : ImageView
        val context = itemView.context
        init {
            lectureImage = itemView.findViewById(R.id.poster_image)
            itemView.setOnClickListener {
                val intent = Intent(context, DetailedPageActivity::class.java)
                intent.run { context.startActivity(this) }
            }
        }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_poster, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Log.d("testt", lectureList.get(0))
        //holder.lectureImage.setImageBitmap(loadImage(lectureList.get(position)))

    }

    override fun getItemCount(): Int {
        return  1
    }


    fun loadImage(imageUrl: String): Bitmap? {
        var bitmap: Bitmap? = null
        val connection: HttpURLConnection?

        try {
            val url = URL(imageUrl)
            connection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "GET" // request 방식 설정
            connection.connectTimeout = 10000 // 10초의 타임아웃
            connection.doOutput = true // OutPutStream으로 데이터를 넘겨주겠다고 설정
            connection.doInput = true // InputStream으로 데이터를 읽겠다는 설정
            connection.useCaches = true // 캐싱 여부
            connection.connect()

            val resCode = connection.responseCode // 연결 상태 확인

            if (resCode == HttpURLConnection.HTTP_OK) { // 200일때 bitmap으로 변경
                val input = connection.inputStream
                bitmap = BitmapFactory.decodeStream(input) // BitmapFactory의 메소드를 통해 InputStream으로부터 Bitmap을 만들어 준다.
                connection.disconnect()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bitmap
    }
}