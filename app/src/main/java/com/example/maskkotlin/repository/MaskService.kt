package com.example.maskkotlin.repository

import com.example.maskkotlin.model.StoreInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MaskService {
    @GET("sample.json/?m=5000")
    fun fetchStoreInfo(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double
        ): Call<StoreInfo>

    // 상수가 저장되는 객체
    companion object {
        const val BASE_URL =
            "https://gist.githubusercontent.com/junsuk5/bb7485d5f70974deee920b8f0cd1e2f0/raw/063f64d9b343120c2cb01a6555cf9b38761b1d94/"
    }

}