package com.example.looc.data


import com.google.gson.annotations.SerializedName

data class LectureDetailItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("credit")
    val credit: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("keword")
    val keword: List<String>,
    @SerializedName("lecture_id")
    val lectureId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("professor")
    val professor: String,
    @SerializedName("room")
    val room: String,
    @SerializedName("score")
    val score: Double,
    @SerializedName("time")
    val time: String
)