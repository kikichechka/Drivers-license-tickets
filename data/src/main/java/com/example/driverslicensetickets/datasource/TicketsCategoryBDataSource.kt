package com.example.driverslicensetickets.datasource

import com.example.driverslicensetickets.MyRetrofit
import com.example.driverslicensetickets.dto.TicketDTO
import retrofit2.Response
import javax.inject.Inject

class TicketsCategoryBDataSource @Inject constructor(
    private val myRetrofit: MyRetrofit
) {

    suspend fun getData(): Response<List<TicketDTO>> {
        return myRetrofit.searchData.getB()
    }
}
