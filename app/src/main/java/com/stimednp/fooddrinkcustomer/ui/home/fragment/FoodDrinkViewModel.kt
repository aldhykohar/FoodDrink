package com.stimednp.fooddrinkcustomer.ui.home.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stimednp.fooddrinkcustomer.data.db.FoodDrinkDao
import com.stimednp.fooddrinkcustomer.data.db.FoodDrinkDatabase
import com.stimednp.fooddrinkcustomer.data.repository.ListItemRepository
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel

class FoodDrinkViewModel(
    private val repository: ListItemRepository
) : ViewModel() {

    suspend fun addItemToBasket(produkModel: ProdukModel) = repository.addToBasket(produkModel)

    suspend fun getDataBasket() = repository.getDataBasket()
}