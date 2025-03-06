package org.example

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {
    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ru-RU",
        @Query("page") page: Int = 1
    ): Call<MovieResponse>
}
