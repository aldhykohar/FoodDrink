package com.stimednp.fooddrinkcustomer.ui.home.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.stimednp.fooddrinkcustomer.data.db.FoodDrinkDatabase
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel

class FoodDrinkViewModel(application: Application) :
    AndroidViewModel(application) {

    var allBasket :MutableLiveData<List<ProdukModel>>

    init {
        allBasket = MutableLiveData()
    }

    fun getAllBasketObservers():MutableLiveData<List<ProdukModel>>{
        return allBasket
    }

    fun getDataBasket() {
        val userDao = FoodDrinkDatabase.getFoodDrinkDatabase((getApplication()))?.foodDrinkDao()
        val list = userDao?.getBasketList()
        allBasket.postValue(list)
    }

    fun insertDataBasket(model: ProdukModel) {
        val userDao = FoodDrinkDatabase.getFoodDrinkDatabase((getApplication()))?.foodDrinkDao()
        userDao?.addToBasketlist(model)
        getDataBasket()
    }
}