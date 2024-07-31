package com.example.driverslicensetickets.model

import com.example.driverslicensetickets.AnswerModel


data class Answer(
    val answerText: String,
    val isCorrect: Boolean
)

fun AnswerModel.toMap(): Answer {
    return Answer(
        answerText = answerText,
        isCorrect = isCorrect
    )
}