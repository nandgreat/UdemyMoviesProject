package com.nandom.udemymoviesproject.data.repository.tvshow.datasource

import com.nandom.udemymoviesproject.data.model.tvshow.TVShow

interface TVShowsLocalDataSource {

    suspend fun getTVShowsFromDB(): List<TVShow>
    suspend fun saveTVShowsToDB(movies: List<TVShow>)
    suspend fun clearAll()
}