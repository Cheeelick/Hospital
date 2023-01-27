package com.example.android.hospitamysql.api

import android.service.autofill.UserData
import android.widget.EditText
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @GET("/getSick.php")
    fun getAllSick(): Call<SickResponse>

//    @POST("/login.php")
//    fun createLogin(@Body post: LoginBody): Call<LoginBody>

}