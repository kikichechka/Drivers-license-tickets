package com.example.driverslicensetickets.usecase

import com.example.driverslicensetickets.TicketModel
import com.example.driverslicensetickets.TicketsRepository
import javax.inject.Inject

class GetTicketsCategoryBUseCaseImpl @Inject constructor(
    private val ticketsRepository: TicketsRepository
): GetTicketsCategoryBUseCase {

    override suspend fun get(): List<TicketModel>? {
        return ticketsRepository.getCategoryB()
    }
}
