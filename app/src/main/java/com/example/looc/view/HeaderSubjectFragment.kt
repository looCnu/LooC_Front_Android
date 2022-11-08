package com.example.looc.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.looc.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class FeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflater xml 이 사용자 눈에 보일 수 있도록 하는 역할 (사용 준비) XML => View
        // container 프라그먼트에서 사용될 XML 의 부모뷰
        return inflater.inflate(R.layout.fragment_subject_header, container, false)
        // attachToRoot 언제 붙을지 결정

    }

}