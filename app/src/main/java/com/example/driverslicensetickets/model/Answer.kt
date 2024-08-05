package com.example.driverslicensetickets.model

import android.os.Parcelable
import com.example.driverslicensetickets.AnswerModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Answer(
    val answerText: String,
    val isCorrect: Boolean
) : Parcelable

fun AnswerModel.toMap(): Answer {
    return Answer(
        answerText = answerText,
        isCorrect = isCorrect
    )
}
