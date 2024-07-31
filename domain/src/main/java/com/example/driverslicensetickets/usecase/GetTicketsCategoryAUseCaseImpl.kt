package com.example.driverslicensetickets.usecase

import com.example.driverslicensetickets.TicketModel
import com.example.driverslicensetickets.TicketsRepository
import javax.inject.Inject

class GetTicketsCategoryAUseCaseImpl @Inject constructor(
    private val ticketsRepository: TicketsRepository
): GetTicketsCategoryAUseCase {

    override suspend fun get(): List<TicketModel>? {
        return ticketsRepository.getCategoryA()
    }
}
