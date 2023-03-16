package com.example.kotlinmovies.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://kinopoiskapiunofficial.tech")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val movieApi = retrofit.create(MovieApi::class.java)
}