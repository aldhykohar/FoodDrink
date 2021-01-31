package com.stimednp.fooddrinkcustomer.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel


@androidx.room.Dao
interface FoodDrinkDao {

    @Query("SELECT * FROM basket")
    fun getBasketList(): List<ProdukModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToBasketlist(tvShow: ProdukModel?)

    @Delete
    fun clearBasket(model: ProdukModel?)

    @Query("UPDATE basket SET count=:count WHERE id = :produkId")
    fun updateItem(produkId: String?, count: Int?): ProdukModel?

    @Query("DELETE FROM basket WHERE id LIKE :produkId")
    fun deleteItemFromBasket(produkId: String?): ProdukModel?

}