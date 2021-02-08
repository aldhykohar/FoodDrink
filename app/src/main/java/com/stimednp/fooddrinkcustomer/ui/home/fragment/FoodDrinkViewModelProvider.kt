package com.stimednp.fooddrinkcustomer.ui.home.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stimednp.fooddrinkcustomer.data.repository.ListItemRepository

class FoodDrinkViewModelProvider(
    private val repository: ListItemRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FoodDrinkViewModel(repository) as T
    }
}