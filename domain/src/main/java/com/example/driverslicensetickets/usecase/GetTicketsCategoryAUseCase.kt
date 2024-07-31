package com.example.driverslicensetickets.usecase

import com.example.driverslicensetickets.TicketModel

interface GetTicketsCategoryAUseCase {
    suspend fun get(): List<TicketModel>?
}