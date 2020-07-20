package com.nandom.udemymoviesproject.data.repository.artist.datasourceimpl

import com.nandom.udemymoviesproject.data.model.artist.Artist
import com.nandom.udemymoviesproject.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl :
    ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }


}