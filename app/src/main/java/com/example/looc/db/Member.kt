package com.example.looc.db

import com.google.gson.annotations.SerializedName

data class Member (

    @SerializedName("student_id")
    val studentId: String,

    @SerializedName("password")
    val pwd: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("college")
    val college : String,

    @SerializedName("preference")
    val preference : List<String>,

    )