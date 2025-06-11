package com.example.network.data.repository

import com.example.network.data.model.CatImageModel
import com.example.network.data.network.CatApiService
import javax.inject.Inject

class CatRepository @Inject constructor(
    private val apiService: CatApiService
) {

    suspend fun fetchCatImages(limit: Int = 10): List<CatImageModel> {
        return apiService.getCatImages(limit = limit)
    }
}
