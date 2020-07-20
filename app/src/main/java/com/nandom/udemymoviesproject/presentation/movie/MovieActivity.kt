package com.nandom.udemymoviesproject.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nandom.udemymoviesproject.R
import com.nandom.udemymoviesproject.databinding.ActivityHomeBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
    }
}