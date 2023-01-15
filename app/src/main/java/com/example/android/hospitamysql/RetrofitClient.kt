package com.example.android.hospitamysql

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.hospitamysql.api.ApiInterface
import com.example.android.hospitamysql.api.Sick
import com.example.android.hospitamysql.api.SickResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "RetrofitClient"
private const val BASE_URL = "http://192.168.56.1/"

class RetrofitClient {

    private val retrofitApi: ApiInterface


    init{
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()


        retrofitApi = retrofit.create(ApiInterface::class.java)
    }

    fun listSick(): LiveData<String>{
        val responseLiveData: MutableLiveData<String> = MutableLiveData()
        val retrofitRequest: Call<String> = retrofitApi.getAllSick()
        retrofitRequest.enqueue(object: Callback<String>{

            override fun onResponse(call: Call<String>, response: Response<String>) {
                responseLiveData.value = response.body()

                Log.d(TAG, "ALL OK")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "ERRORS")
            }

        })
        return responseLiveData
    }





}