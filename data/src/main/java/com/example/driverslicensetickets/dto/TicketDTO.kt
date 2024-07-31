package com.example.driverslicensetickets.dto

import com.example.driverslicensetickets.TicketModel
import com.google.gson.annotations.SerializedName

data class TicketDTO(
    val title: String,
    @SerializedName("ticket_number") val ticketNumber: String,
    @SerializedName("ticket_category") val ticketCategory: String,
    val image: String,
    val question: String,
    val answers: List<AnswerDTO>,
    @SerializedName("correct_answer") val correctAnswer: String,
    @SerializedName("answer_tip") val answerTip: String,
    val topic: List<String>,
    val id: String
)

fun TicketDTO.toModel(): TicketModel {
    return TicketModel(
        title = title,
        ticketNumber = ticketNumber,
        ticketCategory = ticketCategory,
        image = image,
        question = question,
        answers = answers.map { it.toModel() },
        correctAnswer = correctAnswer,
        answerTip = answerTip,
        topic = topic,
        id = id
    )
}