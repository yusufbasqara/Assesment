package com.d3if3071.assesment1_kalkulator.network

import com.d3if3071.assesment1_kalkulator.model.CurrencyModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.exchangerate-api.com/v4/latest/euro"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DataApiService {
    @GET("static-api.json")
    suspend fun getData(): List<CurrencyModel>
}

object DataApi{
    val service: DataApiService by lazy {
        retrofit.create(DataApiService::class.java)
    }

    fun getCurrency(): String {
        return BASE_URL
    }
}
