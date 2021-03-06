package com.example.covid19_statistics.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covid19_statistics.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.navHost, ControlFragment())
            .commit()

    }
}
