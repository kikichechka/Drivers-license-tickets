package com.example.driverslicensetickets.usecase

import com.example.driverslicensetickets.TicketModel

interface GetTicketsCategoryBUseCase {
    suspend fun get(): List<TicketModel>?
}
