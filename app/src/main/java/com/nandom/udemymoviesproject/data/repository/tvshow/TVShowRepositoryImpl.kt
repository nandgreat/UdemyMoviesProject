package com.nandom.udemymoviesproject.data.repository.tvshow

import com.nandom.udemymoviesproject.data.model.tvshow.TVShow
import com.nandom.udemymoviesproject.data.repository.tvshow.datasource.TVShowsCacheDataSource
import com.nandom.udemymoviesproject.data.repository.tvshow.datasource.TVShowsLocalDataSource
import com.nandom.udemymoviesproject.data.repository.tvshow.datasource.TVShowsRemoteDataSource
import com.nandom.udemymoviesproject.domain.repository.TVShowRepository
import java.lang.Exception

class TVShowRepositoryImpl(
    private val tvShowsCacheDataSource: TVShowsCacheDataSource,
    private val tvShowsLocalDataSource: TVShowsLocalDataSource,
    private val tvShowsRemoteDataSource: TVShowsRemoteDataSource
) : TVShowRepository {
    override suspend fun getTVShows(): List<TVShow>? = getTVShowsFromCache()

    override suspend fun updateTVShows(): List<TVShow>? {
        val newTVShowsList = ArrayList<TVShow>()
        tvShowsCacheDataSource.saveTVShowsToCache(newTVShowsList)
        tvShowsLocalDataSource.saveTVShowsToDB(newTVShowsList)
        return newTVShowsList
    }

    suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShows: List<TVShow>

        try {
            val response = tvShowsRemoteDataSource.getTVShows()
            val body = response.body()
            if (body != null)
                tvShows = body.TVShows

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return tvShows
    }

    suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShows: List<TVShow>

        try {
            tvShows = tvShowsLocalDataSource.getTVShowsFromDB()

            if (tvShows.isNotEmpty())
                return tvShows
            else {
                tvShows = getTVShowsFromAPI()
                tvShowsLocalDataSource.saveTVShowsToDB(tvShows)
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
        return tvShows
    }

    suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShows: List<TVShow>

        try {
            tvShows = tvShowsCacheDataSource.getTVShowsFromCache()

            if (tvShows.isNotEmpty())
                return tvShows
            else {
                tvShows = getTVShowsFromDB()
                tvShowsCacheDataSource.saveTVShowsToCache(tvShows)
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
        return tvShows
    }
}