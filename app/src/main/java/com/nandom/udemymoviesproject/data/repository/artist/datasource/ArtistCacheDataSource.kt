package com.nandom.udemymoviesproject.data.repository.artist.datasource

import com.nandom.udemymoviesproject.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun saveArtistsToCache(artists: List<Artist>)
    suspend fun getArtistsFromCache(): List<Artist>
}