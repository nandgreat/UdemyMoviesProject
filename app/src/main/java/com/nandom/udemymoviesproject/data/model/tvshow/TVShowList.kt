package com.nandom.udemymoviesproject.data.model.tvshow


import com.google.gson.annotations.SerializedName
import com.nandom.udemymoviesproject.data.model.tvshow.TVShow

data class TVShowList(
    @SerializedName("results")
    val TVShows: List<TVShow>

)