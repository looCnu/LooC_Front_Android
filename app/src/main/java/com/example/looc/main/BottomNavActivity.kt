package com.example.looc.main

import android.app.Fragment
import android.os.Bundle
import com.example.looc.R
import com.example.looc.databinding.ActivityHomeBinding

class BottomNavActivity : BaseActivity() {


    private lateinit var binding: ActivityHomeBinding
    //바인딩을 시작한다.

    private val fragmentFirstDisplay = mutableListOf(false)

    private val fragmentManager = supportFragmentManager
    private val homeFragment = FeedFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()

    }

    private fun setUpUI() {
        fragmentManager.beginTransaction().apply {
            add(R.id.container, homeFragment, "home" )
        }.commit()
    }


    override fun onAttachFragment(fragment: Fragment) {
        if (fragment is Fragment){

        }
    }

    fun onSubjectFragmentViewCreated() {
        if(!fragmentFirstDisplay[0]){
            fragmentFirstDisplay[0] = true
            homeFragment.onFirstDisplay()
        }
    }

}