package com.example.driverslicensetickets

import com.example.driverslicensetickets.datasource.TicketsCategoryADataSource
import com.example.driverslicensetickets.datasource.TicketsCategoryBDataSource
import com.example.driverslicensetickets.dto.toModel
import javax.inject.Inject

class TicketsRepositoryImpl @Inject constructor(
    private val ticketsCategoryADataSource: TicketsCategoryADataSource,
    private val ticketsCategoryBDataSource: TicketsCategoryBDataSource
) : TicketsRepository {
    override suspend fun getCategoryA(): List<TicketModel>? {
        return ticketsCategoryADataSource.getData().body()?.map { it.toModel() }
    }

    override suspend fun getCategoryB(): List<TicketModel>? {
        return ticketsCategoryBDataSource.getData().body()?.map { it.toModel() }
    }
}
