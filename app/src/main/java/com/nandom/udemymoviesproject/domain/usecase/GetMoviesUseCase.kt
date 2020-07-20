package com.nandom.udemymoviesproject.domain.usecase

import com.nandom.udemymoviesproject.data.model.movie.Movie
import com.nandom.udemymoviesproject.domain.repository.MovieRepository

class GetMoviesUseCase (private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}