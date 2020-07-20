package com.nandom.udemymoviesproject.domain.repository

import com.nandom.udemymoviesproject.data.model.movie.Movie
import com.nandom.udemymoviesproject.data.model.tvshow.TVShow


interface TVShowRepository {

    suspend fun getTVShows(): List<TVShow>?
    suspend fun updateTVShows(): List<TVShow>?
}