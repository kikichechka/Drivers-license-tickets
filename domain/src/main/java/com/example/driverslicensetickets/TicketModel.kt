package com.example.driverslicensetickets

import com.example.driverslicensetickets.AnswerModel

data class TicketModel  (
    val title: String,
    val ticketNumber: String,
    val ticketCategory: String,
    val image: String,
    val question: String,
    val answers: List<AnswerModel>,
    val correctAnswer: String,
    val answerTip: String,
    val topic: List<String>,
    val id: String
)