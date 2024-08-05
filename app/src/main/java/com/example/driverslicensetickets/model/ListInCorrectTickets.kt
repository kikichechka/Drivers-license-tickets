package com.example.driverslicensetickets.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListInCorrectTickets(
    val list: List<IncorrectTicket>
) : Parcelable
