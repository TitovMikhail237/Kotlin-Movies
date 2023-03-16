package com.example.kotlinmovies

import java.io.Serializable

data class Movie(
    val kinopoiskId: String,
    val nameRu: String,
    val nameEn: String,
    val posterUrl: String,
    val ratingImdb: String,
    val shortDescription: String,
):Serializable