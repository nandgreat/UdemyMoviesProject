package com.nandom.udemymoviesproject.data.repository.tvshow.datasourceimpl

import com.nandom.udemymoviesproject.data.api.TMDBService
import com.nandom.udemymoviesproject.data.model.tvshow.TVShowList
import com.nandom.udemymoviesproject.data.repository.tvshow.datasource.TVShowsRemoteDataSource
import retrofit2.Response

class TVShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TVShowsRemoteDataSource {

    override suspend fun getTVShows(): Response<TVShowList> {
        return tmdbService.getPopularTVShows(apiKey)
    }

}