package com.stimednp.fooddrinkcustomer.ui.home

import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel

interface FoodDrinkListener {

    fun onPlusClicked(model: ProdukModel)
    fun onMinusClicked(model: ProdukModel)
    fun onAddClicked(model: ProdukModel)
}