package com.example.driverslicensetickets.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IncorrectTicket(
    val title: String,
    val ticketNumber: String,
    val ticketCategory: String,
    val image: String,
    val question: String,
    val answers: List<Answer>,
    val correctAnswer: String,
    val inCorrectAnswer: Int,
    val answerTip: String,
    val topic: List<String>,
    val id: String
) : Parcelable
