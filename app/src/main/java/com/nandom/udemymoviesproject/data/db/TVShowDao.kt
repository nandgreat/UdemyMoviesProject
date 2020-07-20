package com.nandom.udemymoviesproject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nandom.udemymoviesproject.data.model.tvshow.TVShow

@Dao
interface TVShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveShows(tvshows: List<TVShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteAllShows()

    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getTVShows() : List<TVShow>
}