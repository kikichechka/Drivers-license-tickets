package com.example.driverslicensetickets

import com.example.driverslicensetickets.TicketModel

interface TicketsRepository {
    suspend fun getCategoryA(): List<TicketModel>?
    suspend fun getCategoryB(): List<TicketModel>?
}
