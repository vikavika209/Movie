package org.example

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main() {
    val apiKey = "296b01c76233057b2e8a590b56cb8a46"

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val tmdbApi = retrofit.create(TmdbApi::class.java)

    val response = tmdbApi.getTopRatedMovies(apiKey).execute()

    if (response.isSuccessful) {
        val movies = response.body()?.movies ?: emptyList()
        movies.forEach { println("${it.title} - ${it.rating}") }
    } else {
        println("Ошибка: ${response.code()} - ${response.message()}")
    }
}
