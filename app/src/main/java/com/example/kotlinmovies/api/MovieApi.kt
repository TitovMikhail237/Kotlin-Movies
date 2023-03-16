package com.example.kotlinmovies.api

import com.example.kotlinmovies.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("/api/v2.2/films/{id}")
    fun loadMovie(
        @Path("id") kinopoiskId: String,
        //@Query("appid") apiKey: String
        @Query("X-API-KEY") apiKey: String

    ): Call<Movies>
}