package com.nandom.udemymoviesproject.data.repository.artist.datasource

import com.nandom.udemymoviesproject.data.model.artist.Artist
import com.nandom.udemymoviesproject.data.model.tvshow.TVShow

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}