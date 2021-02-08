package com.stimednp.fooddrinkcustomer

import android.app.Application
import com.stimednp.fooddrinkcustomer.data.db.FoodDrinkDatabase
import com.stimednp.fooddrinkcustomer.data.repository.ListItemRepository
import com.stimednp.fooddrinkcustomer.ui.home.fragment.FoodDrinkViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class FoodDrinkApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@FoodDrinkApplication))

        bind() from singleton { FoodDrinkDatabase(instance()) }
        bind() from singleton { ListItemRepository(instance()) }
        bind() from provider { FoodDrinkViewModelProvider(instance()) }

    }
}