package com.example.shilov.api

import com.example.shilov.model.CustomOrder
import retrofit2.http.*

interface OrderApi {
    @GET("order")
    suspend fun getAll(): List<CustomOrder>

    @POST("order")
    suspend fun add(@Body customOrder: CustomOrder)

    @DELETE("order/{id}")
    suspend fun deleteById(@Path("id") id: Long)
}