package com.nandom.udemymoviesproject.data.db

import androidx.room.*
import com.nandom.udemymoviesproject.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists : List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artists")
    suspend fun getAllArtists() : List<Artist>
}