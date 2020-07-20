package com.nandom.udemymoviesproject.data.repository.tvshow.datasourceimpl

import com.nandom.udemymoviesproject.data.db.TVShowDao
import com.nandom.udemymoviesproject.data.model.tvshow.TVShow
import com.nandom.udemymoviesproject.data.repository.tvshow.datasource.TVShowsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(
    private val tvShowDao: TVShowDao
) : TVShowsLocalDataSource {

    override suspend fun getTVShowsFromDB(): List<TVShow> {
        return tvShowDao.getTVShows()
    }

    override suspend fun saveTVShowsToDB(movies: List<TVShow>) {
        tvShowDao.saveShows(movies)
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllShows()
        }

    }
}