package com.example.network.data.network

import com.example.network.data.model.CatImageModel
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Headers

interface CatApiService {

    @Headers("x-api-key: ")
    @GET("images/search")
    suspend fun getCatImages(
        @Query("limit") limit: Int = 10,
        @Query("has_breeds") hasBreeds: Int = 0,
        @Query("order") order: String = "RAND"
    ): List<CatImageModel>
}

