package com.nandom.udemymoviesproject.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nandom.udemymoviesproject.R
import com.nandom.udemymoviesproject.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}