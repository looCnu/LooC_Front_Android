package com.example.looc.main

import android.graphics.Color
import android.os.Bundle

import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.looc.R
import com.example.looc.databinding.ActivityHomeBinding.inflate
import com.example.looc.databinding.FragmentFeedBinding
import kotlin.math.min


class FeedFragment : BottomNavFragment() {

    private lateinit var binding: FragmentFeedBinding
    //private lateinit var feedViewModel: FeedViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

    }

    override fun onFirstDisplay() {
        super.onFirstDisplay()
    }

//    private fun handleSearchClick() {
//        val intent = Intent(requireActivity(), SearchActivity::class.java)
//        startActivity(intent)
//    }
//
    private fun setupUI() {


        binding.subjectItemList.addOnScrollListener(object : RecyclerView.OnScrollListener(){

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val scrollY: Int = binding.subjectItemList.computeVerticalScrollOffset()

                val color = changeAlpha(
                    ContextCompat.getColor(requireActivity(), R.color.black_transparent),
                    (min(255, scrollY).toFloat()/255.0f).toDouble()
                )
            }
        })

    }


    private fun calculateAndSetListTopPadding() {
        //need to develop Appbarlayout
    }

    private fun changeAlpha(color : Int, fraction: Double) : Int{
        val red: Int = Color.red(color)
        val green: Int = Color.green(color)
        val blue : Int = Color.blue(color)
        val alpha : Int = (Color.alpha(color) *(fraction)).toInt()
        return Color.argb(alpha, red, green, blue)
    }



}