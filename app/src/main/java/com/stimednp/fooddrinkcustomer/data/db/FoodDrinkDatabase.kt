package com.stimednp.fooddrinkcustomer.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stimednp.fooddrinkcustomer.data.dao.FoodDrinkDao
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel


@Database(entities = [ProdukModel::class], version = 1, exportSchema = false)
abstract class FoodDrinkDatabase : RoomDatabase() {

    abstract fun foodDrinkDao(): FoodDrinkDao?

    companion object{
        private var foodDrinkDatabase: FoodDrinkDatabase? = null

        fun getFoodDrinkDatabase(context: Context?): FoodDrinkDatabase? {
            if (foodDrinkDatabase == null) {
                foodDrinkDatabase = Room.databaseBuilder(
                    context!!,
                    FoodDrinkDatabase::class.java,
                    "FoodDrink_db"
                ).build()
            }
            return foodDrinkDatabase
        }
    }
}