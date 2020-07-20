package com.nandom.udemymoviesproject.domain.usecase

import com.nandom.udemymoviesproject.data.model.tvshow.TVShow
import com.nandom.udemymoviesproject.domain.repository.TVShowRepository

class GetTVShowsUseCase (private val tvShowRepository: TVShowRepository) {

    suspend fun execute(): List<TVShow>? = tvShowRepository.getTVShows()
}