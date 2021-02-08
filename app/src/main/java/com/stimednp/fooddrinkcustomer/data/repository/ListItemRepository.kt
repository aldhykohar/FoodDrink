package com.stimednp.fooddrinkcustomer.data.repository

import androidx.lifecycle.LiveData
import com.stimednp.fooddrinkcustomer.data.db.FoodDrinkDatabase
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel

class ListItemRepository(
    private val db: FoodDrinkDatabase
) {
    suspend fun addToBasket(produkModel: ProdukModel) =
        db.foodDrinkDao().addToBasketlist(produkModel)

    suspend fun getDataBasket(): List<ProdukModel> {
        return db.foodDrinkDao().getDataBasket()
    }
}