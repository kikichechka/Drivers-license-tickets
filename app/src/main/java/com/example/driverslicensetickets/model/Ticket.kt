package com.example.driverslicensetickets.model

import android.os.Parcelable
import com.example.driverslicensetickets.TicketModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ticket(
    val title: String,
    val ticketNumber: String,
    val ticketCategory: String,
    val image: String,
    val question: String,
    val answers: List<Answer>,
    val correctAnswer: String,
    val answerTip: String,
    val topic: List<String>,
    val id: String
) : Parcelable

fun Ticket.mapToInCorrect(position: Int): IncorrectTicket {
    return IncorrectTicket(
        title = title,
        ticketNumber = ticketNumber,
        ticketCategory = ticketCategory,
        image = image,
        question = question,
        answers = answers,
        correctAnswer = correctAnswer,
        inCorrectAnswer = position,
        answerTip = answerTip,
        topic = topic,
        id = id
    )
}

fun TicketModel.toMap(): Ticket {
    return Ticket(
        title = title,
        ticketNumber = ticketNumber,
        ticketCategory = ticketCategory,
        image = image,
        question = question,
        answers = answers.map { it.toMap() },
        correctAnswer = correctAnswer,
        answerTip = answerTip,
        topic = topic,
        id = id
    )
}
