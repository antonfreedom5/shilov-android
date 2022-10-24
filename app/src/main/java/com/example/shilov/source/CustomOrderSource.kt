package com.example.shilov.source

import com.example.shilov.api.OrderApi
import com.example.shilov.model.CustomOrder
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CustomOrderSource {
    val moshi = Moshi.Builder().build()
    val moshiConverterFactory = MoshiConverterFactory.create(moshi)
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8081")
        .addConverterFactory(moshiConverterFactory)
        .build()

    private val orderApi = retrofit.create(OrderApi::class.java)

    suspend fun getAll(): List<CustomOrder> = orderApi.getAll()

    suspend fun add(customOrder: CustomOrder) = orderApi.add(customOrder)

    suspend fun deleteById(id: Long): Unit = orderApi.deleteById(id)
}