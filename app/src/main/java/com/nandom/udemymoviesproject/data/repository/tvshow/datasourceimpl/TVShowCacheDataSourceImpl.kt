package com.nandom.udemymoviesproject.data.repository.tvshow.datasourceimpl

import com.nandom.udemymoviesproject.data.model.tvshow.TVShow
import com.nandom.udemymoviesproject.data.repository.tvshow.datasource.TVShowsCacheDataSource

class TVShowCacheDataSourceImpl :
    TVShowsCacheDataSource {

    private var tvShowList = ArrayList<TVShow>()

    override suspend fun saveTVShowsToCache(movie: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(movie)
    }

    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return tvShowList
    }
}