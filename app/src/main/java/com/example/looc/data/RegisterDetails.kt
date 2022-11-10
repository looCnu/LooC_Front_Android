package com.example.looc.data


import com.google.gson.annotations.SerializedName

data class RegisterDetails(
    @SerializedName("student_id")
    val studentId: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("college")
    val college: String,
    @SerializedName("preference")
    val preference: List<String>

)


