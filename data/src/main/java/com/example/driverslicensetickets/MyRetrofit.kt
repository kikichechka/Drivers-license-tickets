package com.example.driverslicensetickets

import com.example.driverslicensetickets.dto.TicketDTO
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url
import javax.inject.Inject

private const val BASE_URL = "https://comandosfru.xyz/pdd/tickets/"

class MyRetrofit @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val searchData: SearchDataApi = retrofit.create(SearchDataApi::class.java)
}

interface SearchDataApi {
    @GET
    suspend fun getA(@Url url: String = "ticket1.json"): Response<List<TicketDTO>>

    @GET
    suspend fun getB(@Url url: String = "ticket2.json"): Response<List<TicketDTO>>
}