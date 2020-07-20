package com.nandom.udemymoviesproject.data.repository.movie

import com.nandom.udemymoviesproject.data.api.TMDBService
import com.nandom.udemymoviesproject.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}