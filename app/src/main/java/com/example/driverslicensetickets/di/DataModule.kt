package com.example.driverslicensetickets.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
//
//    @Provides
//    @Singleton
//    fun provideGetTicketsCategoryAUseCase(
//        ticketsRepository: TicketsRepositoryImpl
//    ): GetTicketsCategoryAUseCase {
//        return GetTicketsCategoryAUseCaseImpl(
//            ticketsRepository = ticketsRepository
//        )
//    }
//
//    @Provides
//    @Singleton
//    fun provideGetTicketsCategoryBUseCase(
//        ticketsRepository: TicketsRepositoryImpl
//    ): GetTicketsCategoryBUseCase {
//        return GetTicketsCategoryBUseCaseImpl(
//            ticketsRepository = ticketsRepository
//        )
//    }
}
