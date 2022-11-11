package com.example.looc.data


import com.google.gson.annotations.SerializedName

data class LectureDetailItem(
    @SerializedName("lecture_id")
    val lectureId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("credit")
    val credit: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("room")
    val room: String,
    @SerializedName("professor")
    val professor: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("keyword")
    val keyword: List<String>,
    @SerializedName("score")
    val score: Double
)