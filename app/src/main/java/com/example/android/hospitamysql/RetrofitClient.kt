package com.example.android.hospitamysql

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.hospitamysql.api.ApiInterface
import com.example.android.hospitamysql.api.LoginBody
import com.example.android.hospitamysql.api.Sick
import com.example.android.hospitamysql.api.SickResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "RetrofitClient"
private const val BASE_URL = "http://192.168.0.103/"

class RetrofitClient {


    private val retrofitApi: ApiInterface


    init{
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        retrofitApi = retrofit.create(ApiInterface::class.java)
    }

    fun listSick(): LiveData<List<Sick>> {
        val responseLiveData: MutableLiveData<List<Sick>> = MutableLiveData()
        val retrofitRequest: Call<SickResponse> = retrofitApi.getAllSick()
        retrofitRequest.enqueue(object: Callback<SickResponse>{

            override fun onResponse(call: Call<SickResponse>, response: Response<SickResponse>) {
                val resultBody: List<Sick> = response.body()!!.Sick.toMutableList()

                Log.d(TAG, "ALLLLL OOOOOK")
                responseLiveData.value = resultBody

            }

            override fun onFailure(call: Call<SickResponse>, t: Throwable) {
                Log.e(TAG, "ERRRRRRRRRROOOOOOOOOORRRRRRRS")
            }

        })
        return responseLiveData
    }

//    fun login(loginData: LoginBody): LiveData<Response<LoginBody>> {
//        val retrofitRequest: Call<LoginBody> = retrofitApi.createLogin(loginData)
//        val responseLiveData: MutableLiveData<Response<LoginBody>> = MutableLiveData()
//        retrofitRequest.enqueue(object: Callback<LoginBody>{
//            override fun onResponse(call: Call<LoginBody>, response: Response<LoginBody>) {
//                responseLiveData.value = response
//            }
//
//            override fun onFailure(call: Call<LoginBody>, t: Throwable) {
//                Log.e(TAG, "ERROR")
//            }
//
//        })
//        return responseLiveData
//
//    }






}