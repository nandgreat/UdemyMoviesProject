package com.nandom.udemymoviesproject.domain.repository

import com.nandom.udemymoviesproject.data.model.movie.Movie


interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}