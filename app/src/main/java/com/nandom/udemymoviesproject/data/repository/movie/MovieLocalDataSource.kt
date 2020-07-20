package com.nandom.udemymoviesproject.data.repository.movie

import com.nandom.udemymoviesproject.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}