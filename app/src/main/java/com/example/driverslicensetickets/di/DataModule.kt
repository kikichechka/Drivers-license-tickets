package com.example.driverslicensetickets.di

import com.example.driverslicensetickets.TicketsRepositoryImpl
import com.example.driverslicensetickets.usecase.GetTicketsCategoryAUseCase
import com.example.driverslicensetickets.usecase.GetTicketsCategoryAUseCaseImpl
import com.example.driverslicensetickets.usecase.GetTicketsCategoryBUseCase
import com.example.driverslicensetickets.usecase.GetTicketsCategoryBUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideGetTicketsCategoryAUseCase(
        ticketsRepository: TicketsRepositoryImpl
    ): GetTicketsCategoryAUseCase {
        return GetTicketsCategoryAUseCaseImpl(
            ticketsRepository = ticketsRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetTicketsCategoryBUseCase(
        ticketsRepository: TicketsRepositoryImpl
    ): GetTicketsCategoryBUseCase {
        return GetTicketsCategoryBUseCaseImpl(
            ticketsRepository = ticketsRepository
        )
    }
}
