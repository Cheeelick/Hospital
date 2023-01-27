package com.example.android.hospitamysql.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.android.hospitamysql.R
import com.example.android.hospitamysql.RetrofitClient
import com.example.android.hospitamysql.api.LoginBody

private const val TAG = "LoginFragment"

class LoginFragment: Fragment() {

    private lateinit var loginData: LoginBody
    private lateinit var test: RetrofitClient
    private lateinit var fioAdministrator: EditText
    private lateinit var numberAdministrator: EditText
    private lateinit var buttonRegistration: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        fioAdministrator = view.findViewById(R.id.fio_Administrator)
        numberAdministrator = view.findViewById(R.id.number_Administrator)
        buttonRegistration = view.findViewById(R.id.button_Registration)

//        val loginData = LoginBody(fioAdministrator.text.toString(), numberAdministrator.text.toString())

//        buttonRegistration.setOnClickListener() {
//            test.login(loginData)
//            Log.d(TAG, "AAAAA")
//        }

        return view
    }


    companion object{
        fun newInstance(): LoginFragment{
            return LoginFragment()
        }
    }
}