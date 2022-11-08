package com.example.looc.view

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.ItemTouchUIUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.looc.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lectureList = mutableListOf<ImageView>()

        val recyclerView = findViewById<RecyclerView>(R.id.main_recycler_view)
        recyclerView.adapter = RecyclerViewAdapter(LayoutInflater.from(this))
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }


}

class RecyclerViewAdapter(
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
        //holder.lectureImage.setImageDrawable(R.drawable.poster_bg)

    }

    override fun getItemCount(): Int {
        return  8
    }
}