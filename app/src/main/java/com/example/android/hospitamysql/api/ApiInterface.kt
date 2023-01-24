package com.example.android.hospitamysql.api

import android.widget.EditText
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("/login.php")
    fun getAllSick(): Call<String>

}