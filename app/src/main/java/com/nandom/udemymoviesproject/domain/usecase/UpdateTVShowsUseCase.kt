package com.nandom.udemymoviesproject.domain.usecase

import com.nandom.udemymoviesproject.data.model.tvshow.TVShow
import com.nandom.udemymoviesproject.domain.repository.TVShowRepository

class UpdateTVShowsUseCase(private val tvshowRepository: TVShowRepository) {

    suspend fun execute(): List<TVShow>? = tvshowRepository.updateTVShows()

}