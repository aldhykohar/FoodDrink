package com.stimednp.fooddrinkcustomer.data.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel


@androidx.room.Dao
interface FoodDrinkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToBasketlist(produk: ProdukModel?)

    @Query("SELECT * FROM basket")
    suspend fun getDataBasket(): List<ProdukModel>
}