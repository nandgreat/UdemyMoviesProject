package com.nandom.udemymoviesproject.data.repository.movie

import com.nandom.udemymoviesproject.data.model.movie.Movie

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun saveMoviesToCache(movie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movie)
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }
}