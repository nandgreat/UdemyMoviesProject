package com.nandom.udemymoviesproject.data.repository.artist.datasourceimpl

import com.nandom.udemymoviesproject.data.api.TMDBService
import com.nandom.udemymoviesproject.data.model.artist.ArtistList
import com.nandom.udemymoviesproject.data.repository.artist.datasource.ArtistsRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistsRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)
    }

}