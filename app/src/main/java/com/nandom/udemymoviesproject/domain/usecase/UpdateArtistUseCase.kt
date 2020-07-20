package com.nandom.udemymoviesproject.domain.usecase

import com.nandom.udemymoviesproject.data.model.artist.Artist
import com.nandom.udemymoviesproject.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()

}