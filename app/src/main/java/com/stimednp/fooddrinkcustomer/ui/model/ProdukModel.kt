package com.stimednp.fooddrinkcustomer.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basket")
data class ProdukModel(
    @PrimaryKey
    var id: String,
    var title: String,
    var image: String,
    var price: String,
    var count: Int
)