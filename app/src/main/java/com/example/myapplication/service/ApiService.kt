package com.example.myapplication.service

import com.example.myapplication.model.ImageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("crawl_images/")
    fun getCrawledImages(
        @Query("keyword") keyword: String
    ): Call<ImageResponse>
}

interface ApiService2 {
    @GET("getProducts")
    suspend fun getProduct(
        @Query("category") category: String?
    ): List<List<String>>
}
