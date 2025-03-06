package org.example

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("vote_average") val rating: Double
)

data class MovieResponse(
    @SerializedName("results") val movies: List<Movie>
)
