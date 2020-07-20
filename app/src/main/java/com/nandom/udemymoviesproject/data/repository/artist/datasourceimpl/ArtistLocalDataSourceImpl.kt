package com.nandom.udemymoviesproject.data.repository.artist.datasourceimpl

import com.nandom.udemymoviesproject.data.db.ArtistDao
import com.nandom.udemymoviesproject.data.model.artist.Artist
import com.nandom.udemymoviesproject.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private val artistDao: ArtistDao
) : ArtistLocalDataSource {

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getAllArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        artistDao.saveArtist(artists)
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }

    }
}