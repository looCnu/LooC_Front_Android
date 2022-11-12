package com.devtides.coroutinesretrofit.view

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.example.looc.R

fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .error(R.mipmap.ic_launcher_round)
        Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}