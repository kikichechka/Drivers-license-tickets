package com.example.driverslicensetickets.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.driverslicensetickets.model.Ticket
import com.example.driverslicensetickets.model.toMap
import com.example.driverslicensetickets.usecase.GetTicketsCategoryAUseCase
import com.example.driverslicensetickets.usecase.GetTicketsCategoryBUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainChoiceViewModel @Inject constructor(
    private val getTicketsCategoryAUseCase: GetTicketsCategoryAUseCase,
    private val getTicketsCategoryBUseCase: GetTicketsCategoryBUseCase
) : ViewModel() {
    private val _ticketsCategoryA: MutableStateFlow<List<Ticket>?> = MutableStateFlow(null)
    val ticketsCategoryA: StateFlow<List<Ticket>?> = _ticketsCategoryA.asStateFlow()

    private val _ticketsCategoryB: MutableStateFlow<List<Ticket>?> = MutableStateFlow(null)
    val ticketsCategoryB: StateFlow<List<Ticket>?> = _ticketsCategoryB.asStateFlow()

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            try {
                _ticketsCategoryA.value = getTicketsCategoryAUseCase.get()?.map { it.toMap() }
                _ticketsCategoryB.value = getTicketsCategoryBUseCase.get()?.map { it.toMap() }
            } catch (_: Exception) {
            }
        }
    }
}
