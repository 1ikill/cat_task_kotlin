package com.example.network.data.model

import com.google.gson.annotations.SerializedName

data class CatImageModel(
    val id: String,
    val url: String,
    val width: Int?,
    val height: Int?,
    val breeds: List<Breed> = emptyList()
)

data class Breed(
    val id: String,
    val name: String,
    val temperament: String?,
    val origin: String?,
    @SerializedName("life_span") val lifeSpan: String?,
    @SerializedName("wikipedia_url") val wikipediaUrl: String?
)
