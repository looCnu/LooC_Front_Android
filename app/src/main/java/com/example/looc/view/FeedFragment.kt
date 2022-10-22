package com.example.looc.view

import android.os.Bundle

import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.looc.R
import com.example.looc.databinding.FragmentFeedBinding


class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    //private lateinit var feedViewModel: FeedViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }


}