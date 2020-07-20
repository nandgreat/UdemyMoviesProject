package com.nandom.udemymoviesproject.data.repository.tvshow.datasource

import com.nandom.udemymoviesproject.data.model.tvshow.TVShow

interface TVShowsCacheDataSource {
    suspend fun saveTVShowsToCache(movie: List<TVShow>)
    suspend fun getTVShowsFromCache(): List<TVShow>
}