package com.nandom.udemymoviesproject.data.repository.artist.datasource

import com.nandom.udemymoviesproject.data.model.artist.ArtistList
import com.nandom.udemymoviesproject.data.model.tvshow.TVShowList
import retrofit2.Response

interface ArtistsRemoteDataSource {

    suspend fun getArtists() : Response<ArtistList>

}