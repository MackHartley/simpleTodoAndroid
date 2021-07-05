package com.mackhartley.simpletodo.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.mackhartley.simpletodo.R

class MainActivity : AppCompatActivity() {
    private var loadingIndicator: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadingIndicator = findViewById(R.id.loading_indicator)
    }

    fun setLoading(isLoading: Boolean) {
        if (isLoading) {
            loadingIndicator?.visibility = View.VISIBLE
        } else {
            loadingIndicator?.visibility = View.GONE
        }
    }
}