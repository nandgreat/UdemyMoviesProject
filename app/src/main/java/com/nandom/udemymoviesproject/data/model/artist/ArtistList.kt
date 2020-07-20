package com.nandom.udemymoviesproject.data.model.artist


import com.google.gson.annotations.SerializedName
import com.nandom.udemymoviesproject.data.model.artist.Artist

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>

)