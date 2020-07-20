package com.nandom.udemymoviesproject.data.repository.artist

import com.nandom.udemymoviesproject.data.model.artist.Artist
import com.nandom.udemymoviesproject.data.repository.artist.datasource.ArtistCacheDataSource
import com.nandom.udemymoviesproject.data.repository.artist.datasource.ArtistLocalDataSource
import com.nandom.udemymoviesproject.data.repository.artist.datasource.ArtistsRemoteDataSource
import com.nandom.udemymoviesproject.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistsRemoteDataSource: ArtistsRemoteDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newTVShowsList = ArrayList<Artist>()
        artistCacheDataSource.saveArtistsToCache(newTVShowsList)
        artistLocalDataSource.saveArtistsToDB(newTVShowsList)
        return newTVShowsList
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            val response = artistsRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null)
                artists = body.artists

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return artists
    }

    suspend fun getAritstFromDB(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            artists = artistLocalDataSource.getArtistsFromDB()

            if (artists.isNotEmpty())
                return artists
            else {
                artists = getArtistFromAPI()
                artistLocalDataSource.saveArtistsToDB(artists)
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
        return artists
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
//            artists = artistCacheDataSource.getArtistsFromCache()

            if (artists.isNotEmpty())
                return artists
            else {
                artists = getAritstFromDB()
                artistCacheDataSource.saveArtistsToCache(artists)
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
        return artists
    }


}