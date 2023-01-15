package com.example.android.hospitamysql.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.android.hospitamysql.R
import com.example.android.hospitamysql.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment: Fragment() {

    private lateinit var fioAdministrator: EditText
    private lateinit var numberAdministrator: EditText
    private lateinit var buttonRegistration: Button



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        fioAdministrator = view.findViewById(R.id.fioAdministrator)
        numberAdministrator = view.findViewById(R.id.numberAdministrator)
        buttonRegistration = view.findViewById(R.id.buttonRegistration)

        buttonRegistration.setOnClickListener(){
//            adminSign(inflater)
        }

        return view
    }



//    fun adminSign(inflater: LayoutInflater) : LoginModel? {
//        var s: LoginModel?
//
//        val result: Call<LoginModel> = RetrofitClient.newInstance().api.loginAdministrator(
//            fioAdministrator,
//            numberAdministrator,
//        )
//
//        result.enqueue(object: Callback<LoginModel>{
//            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
//                s = response.body()
//                Toast.makeText(inflater.context, "VSE POLYCHILOS", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
//                Toast.makeText(inflater.context, "ERRORR NIXYA NE POLYCHILOS", Toast.LENGTH_SHORT).show()
//            }
//        })
//        return s
//    }


    companion object{
        fun newInstance(): LoginFragment{
            return LoginFragment()
        }
    }
}