package com.nandom.udemymoviesproject.data.model.movie


import com.google.gson.annotations.SerializedName
import com.nandom.udemymoviesproject.data.model.movie.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>

)