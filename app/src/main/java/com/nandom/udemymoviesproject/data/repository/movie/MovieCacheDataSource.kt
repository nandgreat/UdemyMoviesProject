package com.nandom.udemymoviesproject.data.repository.movie

import com.nandom.udemymoviesproject.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun saveMoviesToCache(movie: List<Movie>)
    suspend fun getMoviesFromCache(): List<Movie>
}