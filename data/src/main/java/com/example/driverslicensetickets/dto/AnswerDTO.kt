package com.example.driverslicensetickets.dto

import com.example.driverslicensetickets.AnswerModel
import com.google.gson.annotations.SerializedName

data class AnswerDTO(
    @SerializedName("answer_text") val answerText: String,
    @SerializedName("is_correct") val isCorrect: Boolean
)

fun AnswerDTO.toModel(): AnswerModel {
    return AnswerModel(
        answerText = answerText,
        isCorrect = isCorrect
    )
}
