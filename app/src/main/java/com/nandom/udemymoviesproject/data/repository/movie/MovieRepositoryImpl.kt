package com.nandom.udemymoviesproject.data.repository

import com.nandom.udemymoviesproject.data.repository.movie.MovieCacheDataSource
import com.nandom.udemymoviesproject.data.repository.movie.MovieLocalDataSource
import com.nandom.udemymoviesproject.data.repository.movie.MovieRemoteDataSource

import com.nandom.udemymoviesproject.data.model.movie.Movie
import com.nandom.udemymoviesproject.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {

                val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.movies
            }

        }catch (e: Exception){

        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {

            movieList = movieLocalDataSource.getMoviesFromDB()

            if(movieList.size > 0){
                return movieList
            }else{
                movieList = getMoviesFromAPI()
                movieLocalDataSource.saveMoviesToDB(movieList)
            }
        }catch (e: Exception){

        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {

            movieList = movieCacheDataSource.getMoviesFromCache()

            if(movieList.isNotEmpty()){
                return movieList
            }else{
                movieList = getMoviesFromDB()
                movieCacheDataSource.saveMoviesToCache(movieList)
            }
        }catch (e: Exception){

        }
        return movieList
    }
}