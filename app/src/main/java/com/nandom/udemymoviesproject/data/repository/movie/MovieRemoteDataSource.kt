package com.nandom.udemymoviesproject.data.repository.movie

import com.nandom.udemymoviesproject.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies() : Response<MovieList>
}