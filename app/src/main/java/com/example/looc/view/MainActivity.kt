package com.example.looc.view

import RetrofitInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchUIUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.looc.R
import com.example.looc.data.LecturePoster
import com.example.looc.server.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.http2.Http2Connection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//       val imageView = findViewById<ImageView>(R.id.test_image)
//       Glide.with(this).load("https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9791190977852.jpg").into(imageView)

        val recommendLectureList = mutableListOf<LecturePoster>()
        val topScoreLectureList = mutableListOf<LecturePoster>()
        val similarLectureList = mutableListOf<LecturePoster>()

        val retrofit = RetrofitClient.retrofit
        retrofit.create(RetrofitInterface::class.java).attachPoster().enqueue(object : Callback<ArrayList<LecturePoster>>{
            override fun onResponse(
                call: Call<ArrayList<LecturePoster>>,
                response: Response<ArrayList<LecturePoster>>
            ) {
                if(response.isSuccessful){

                    val lecturePoster = response.body()

                    for (i in 0..10){
                        recommendLectureList.add(lecturePoster!!.get(i))
                    }

                    for (i in 10..20){
                        topScoreLectureList.add(lecturePoster!!.get(i))
                    }

                    for (i in 20..30){
                        similarLectureList.add(lecturePoster!!.get(i))
                    }

                }
            }
            override fun onFailure(call: Call<ArrayList<LecturePoster>>, t: Throwable) {
                Log.d("testt", "메인화면 이미지 불러오기 실패ㄴ")
            }
        })


        val recommendRecyclerView = findViewById<RecyclerView>(R.id.recommend_recycler_view)
        val topScoreRecyclerView = findViewById<RecyclerView>(R.id.top_score_recycler_view)
        val similarRecyclerView = findViewById<RecyclerView>(R.id.similar_recycler_view)

        recommendRecyclerView.adapter = RecyclerViewAdapter(recommendLectureList, LayoutInflater.from(this))
        topScoreRecyclerView.adapter = RecyclerViewAdapter(topScoreLectureList, LayoutInflater.from(this))
        similarRecyclerView.adapter = RecyclerViewAdapter(similarLectureList, LayoutInflater.from(this))



    }


}

private fun convertBitmapFromUPL(url : String): Bitmap? {
    try {
        val url = URL(url)
        val connection = url.openConnection() as HttpURLConnection
        connection.doInput = true
        connection.connect()
        val input = connection.inputStream
        val bitmap = BitmapFactory.decodeStream(input)
    } catch (e: IOException){
        Log.d("testt", "convert error")
    }
    return null
}


class RecyclerViewAdapter(
    var lectureList : List<LecturePoster>,
    var inflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //inner class
        val lectureImage : ImageView
        val lectureName : TextView
        val context = itemView.context
        init {
            lectureImage = itemView.findViewById(R.id.poster_image)
            lectureName = itemView.findViewById(R.id.poster_name)
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
        //holder.lectureName.text = lectureList.get(position).lectureName
        //holder.lectureImage.setImageBitmap(loadImage(lectureList.get(position).lectureImage))

    }

    override fun getItemCount(): Int {
        return  8
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