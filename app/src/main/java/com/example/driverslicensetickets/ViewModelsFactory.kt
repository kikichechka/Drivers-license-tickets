package com.example.driverslicensetickets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.driverslicensetickets.fragments.MainChoiceViewModel
import javax.inject.Inject

class ViewModelsFactory @Inject constructor(
    private val mainChoiceViewModel: MainChoiceViewModel,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainChoiceViewModel::class.java)) {
            return mainChoiceViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
