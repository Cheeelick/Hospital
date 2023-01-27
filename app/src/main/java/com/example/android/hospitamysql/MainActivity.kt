package com.example.android.hospitamysql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.hospitamysql.fragments.LoginFragment
import com.example.android.hospitamysql.fragments.SickListFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val fragment = LoginFragment.newInstance()
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.fragment_container, fragment)
//            .commit()
//
        val fragment = SickListFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()


    }


}