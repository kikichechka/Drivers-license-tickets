package com.example.driverslicensetickets.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListTickets(
    val nameCategory: String,
    val list: List<Ticket>
) : Parcelable
