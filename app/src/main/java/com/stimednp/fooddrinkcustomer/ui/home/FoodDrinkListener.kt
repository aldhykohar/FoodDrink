package com.stimednp.fooddrinkcustomer.ui.home

import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel

interface FoodDrinkListener {

    fun onPlusClicked(model: ProdukModel, count: Int)
    fun onMinusClicked(model: ProdukModel,count: Int)
    fun onAddClicked(model: ProdukModel)
}