package com.example.driverslicensetickets.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainChoiceViewModel @Inject constructor(
//    getTicketsCategoryAUseCase: GetTicketsCategoryAUseCase,
//    getTicketsCategoryBUseCase: GetTicketsCategoryBUseCase
): ViewModel() {
//    private val _ticketsCategoryA: MutableStateFlow<List<Ticket>?> = MutableStateFlow(null)
//    val ticketsCategoryA: StateFlow<List<Ticket>?> = _ticketsCategoryA.asStateFlow()
//
//    private val _ticketsCategoryB: MutableStateFlow<List<Ticket>?> = MutableStateFlow(null)
//    val ticketsCategoryB: StateFlow<List<Ticket>?> = _ticketsCategoryB.asStateFlow()
//
//    init {
//         viewModelScope.launch {
//             _ticketsCategoryA.value = getTicketsCategoryAUseCase.get()?.map { it.toMap() }
//             _ticketsCategoryB.value = getTicketsCategoryBUseCase.get()?.map { it.toMap() }
//         }
//    }
}