package com.nandom.udemymoviesproject.data.repository.tvshow.datasource

import com.nandom.udemymoviesproject.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowsRemoteDataSource {

    suspend fun getTVShows() : Response<TVShowList>

}