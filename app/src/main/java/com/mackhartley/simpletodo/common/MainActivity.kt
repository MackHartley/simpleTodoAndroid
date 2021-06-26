package com.mackhartley.simpletodo.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mackhartley.simpletodo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}