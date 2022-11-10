package com.example.looc.data


import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("student_id")
    val studentId: String,
    @SerializedName("password")
    val password: String
)